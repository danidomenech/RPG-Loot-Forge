package com.danidomenech.dndlootforge.ui.screens.loottables

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.model.LootTable
import com.danidomenech.dndlootforge.data.model.LootTableEntry
import com.danidomenech.dndlootforge.data.repository.ItemRepository
import com.danidomenech.dndlootforge.ui.base.BaseViewModel
import com.danidomenech.dndlootforge.utils.ItemUtils
import com.danidomenech.dndlootforge.utils.ItemUtils.isGear
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@HiltViewModel
class LootTablesViewModel @Inject constructor(
    application: Application,
    private val itemRepository: ItemRepository
) : BaseViewModel(application) {

    private val _lootTables = MutableStateFlow<Map<LootTable, List<LootTableEntry>>>(emptyMap())
    val lootTables: StateFlow<Map<LootTable, List<LootTableEntry>>> = _lootTables
    val showOnlyGear = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            combine(
                showOnlyGear,
                flow { emit(itemRepository.getAllItems()) } // Emits once
            ) { onlyGear, allItems ->
                val filteredItems = if (onlyGear) {
                    allItems.filter { it.type.isGear() }
                } else {
                    allItems
                }

                val allTableEntries = ItemUtils.lootTableRanges.mapValues { (table, range) ->
                    computeTableEntriesForTable(table, filteredItems, range)
                }

                allTableEntries
            }.collect {
                _lootTables.value = it
            }
        }
    }

    fun setShowOnlyGear(onlyGear : Boolean) {
        showOnlyGear.value = onlyGear
    }

    private fun computeTableEntriesForTable(
        table: LootTable,
        allItems: List<Item>,
        powerRange: IntRange
    ): List<LootTableEntry> {

        // Step 1: Filter eligible items
        val eligibleItems = allItems.filter { item ->
            (item.powerLevel in powerRange || item.overrideTables?.contains(table) == true) &&
                    !item.vendorExclusive &&
                    !item.narrativeLootExclusive
        }

        // Step 2: Calculate individual weights
        val maxPL = powerRange.last
        val weightedItems = eligibleItems.map { item ->
            val adjustedPL = getItemPowerLevelForTable(item, powerRange)
            val weight = (maxPL + 1 - adjustedPL).coerceAtLeast(1)
            WeightedItem(item, weight)
        }

        // Step 3: Total weight
        val totalWeight = weightedItems.sumOf { it.weight }

        // Step 4: Assign slot ranges starting from 100 down to 1
        val sortedItems = weightedItems.sortedWith(
            compareByDescending<WeightedItem> { getItemPowerLevelForTable(it.item, powerRange) }
                .thenByDescending { it.item.powerLevel }
        )
        val entries = mutableListOf<LootTableEntry>()

        var currentMax = 100
        for ((index, weighted) in sortedItems.withIndex()) {
            val item = weighted.item
            val slots = ((weighted.weight * 100f) / totalWeight).roundToInt().coerceAtLeast(1)

            val isLast = index == sortedItems.lastIndex
            val rangeStart = if (isLast) 1 else (currentMax - slots + 1).coerceAtLeast(1)
            val range = rangeStart..currentMax

            entries += LootTableEntry(formatRange(range), item)
            currentMax = rangeStart - 1
        }

        return entries.reversed()
    }

    private data class WeightedItem(val item: Item, val weight: Int)

    private fun getItemPowerLevelForTable(item: Item, powerRange: IntRange): Int {
        val minRange = powerRange.first
        val maxRange = powerRange.last
        return when {
            item.powerLevel in powerRange -> item.powerLevel
            item.powerLevel < minRange -> minRange
            else -> maxRange
        }
    }

    private fun formatRange(range: IntRange): String =
        if (range.first == range.last) "${range.first}" else "${range.first}-${range.last}"
}