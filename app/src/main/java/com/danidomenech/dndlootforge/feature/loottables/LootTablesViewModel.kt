package com.danidomenech.dndlootforge.feature.loottables

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootTable
import com.danidomenech.dndlootforge.domain.model.LootTableEntry
import com.danidomenech.dndlootforge.domain.model.isGear
import com.danidomenech.dndlootforge.domain.rules.LootTableRules
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.roundToInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class LootTablesViewModel @Inject constructor(
    getAllItemsUseCase: GetAllItemsUseCase
) : ViewModel() {

    private val allItems = MutableStateFlow(getAllItemsUseCase())
    private val showOnlyGear = MutableStateFlow(false)

    val uiState: StateFlow<LootTablesUiState> = combine(
        allItems,
        showOnlyGear
    ) { allItems, showOnlyGear ->
        val filteredItems = if (showOnlyGear) {
            allItems.filter { it.type.isGear }
        } else {
            allItems
        }

        val lootTables = LootTableRules.lootTableRanges.mapValues { (table, range) ->
            computeTableEntriesForTable(
                table = table,
                allItems = filteredItems,
                powerRange = range
            )
        }

        LootTablesUiState(
            lootTables = lootTables,
            showOnlyGear = showOnlyGear
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
        initialValue = LootTablesUiState()
    )

    fun onAction(action: LootTablesAction) {
        when (action) {
            is LootTablesAction.ShowOnlyGearChange -> {
                setShowOnlyGear(action.showOnlyGear)
            }

            is LootTablesAction.ItemClick -> {
                // Handled by Route.
            }
        }
    }

    private fun setShowOnlyGear(onlyGear: Boolean) {
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
        val maxPowerLevel = powerRange.last
        val weightedItems = eligibleItems.map { item ->
            val adjustedPowerLevel = getItemPowerLevelForTable(item, powerRange)
            val weight = (maxPowerLevel + 1 - adjustedPowerLevel).coerceAtLeast(1)

            WeightedItem(
                item = item,
                weight = weight
            )
        }

        // Step 3: Total weight
        val totalWeight = weightedItems.sumOf { it.weight }

        if (totalWeight == 0) return emptyList()

        // Step 4: Assign slot ranges starting from 100 down to 1
        val sortedItems = weightedItems.sortedWith(
            compareByDescending<WeightedItem> {
                getItemPowerLevelForTable(it.item, powerRange)
            }.thenByDescending {
                it.item.powerLevel
            }
        )

        val entries = mutableListOf<LootTableEntry>()
        var currentMax = MAX_DICE_VALUE

        for ((index, weighted) in sortedItems.withIndex()) {
            val item = weighted.item
            val slots = ((weighted.weight * MAX_DICE_VALUE.toFloat()) / totalWeight)
                .roundToInt()
                .coerceAtLeast(1)

            val isLast = index == sortedItems.lastIndex
            val rangeStart = if (isLast) {
                MIN_DICE_VALUE
            } else {
                (currentMax - slots + 1).coerceAtLeast(MIN_DICE_VALUE)
            }

            val range = rangeStart..currentMax

            entries += LootTableEntry(
                range = formatRange(range),
                item = item
            )

            currentMax = rangeStart - 1
        }

        return entries.reversed()
    }

    private fun getItemPowerLevelForTable(
        item: Item,
        powerRange: IntRange
    ): Int {
        val minRange = powerRange.first
        val maxRange = powerRange.last

        return when {
            item.powerLevel in powerRange -> item.powerLevel
            item.powerLevel < minRange -> minRange
            else -> maxRange
        }
    }

    private fun formatRange(range: IntRange): String {
        return if (range.first == range.last) {
            range.first.toString()
        } else {
            "${range.first}-${range.last}"
        }
    }

    private data class WeightedItem(
        val item: Item,
        val weight: Int
    )

    private companion object {
        const val STOP_TIMEOUT_MILLIS = 5_000L
        const val MIN_DICE_VALUE = 1
        const val MAX_DICE_VALUE = 100
    }
}