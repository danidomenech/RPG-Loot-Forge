package com.danidomenech.dndlootforge.feature.vendor

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.repository.ItemRepository
import com.danidomenech.dndlootforge.core.ui.BaseViewModel
import com.danidomenech.dndlootforge.domain.model.sortOrder
import com.danidomenech.dndlootforge.domain.rules.LootTableRules
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VendorViewModel @Inject constructor(
    application: Application,
    private val itemRepository: ItemRepository
) : BaseViewModel(application) {

    private val _playerLevel = MutableStateFlow(1)
    val playerLevel: StateFlow<Int> = _playerLevel

    private val _vendorItems = MutableStateFlow<List<Item>>(emptyList())
    val vendorItems: StateFlow<List<Item>> = _vendorItems

    private lateinit var allVendorItems: List<Item>

    init {
        viewModelScope.launch {
            val allItems = itemRepository.getAllItems()
            allVendorItems = allItems.filter { it.vendorExclusive ||
                    (!it.lootExclusive && !it.narrativeLootExclusive) }
            updateFilteredItems()
        }
    }

    fun setPlayerLevel(level: Int) {
        _playerLevel.value = level
        updateFilteredItems()
    }

    private fun updateFilteredItems() {
        val level = _playerLevel.value
        val allowedTables = LootTableRules.getTablesForPlayerLevel(level)
        val allowedRanges = allowedTables.mapNotNull { LootTableRules.lootTableRanges[it] }

        val filteredItems = allVendorItems.filter { item ->
            allowedRanges.any { range -> item.powerLevel in range }
        }

        // 🔽 Sort by item type and then by rarity
        val sortedItems = filteredItems.sortedWith(
            compareBy(
                { typeOrder.indexOf(it.type) },
                { it.rarity.sortOrder }
            )
        )

        _vendorItems.value = sortedItems
    }
}