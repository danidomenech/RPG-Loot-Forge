package com.danidomenech.dndlootforge.ui.screens.vendor

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.repository.ItemRepository
import com.danidomenech.dndlootforge.ui.base.BaseViewModel
import com.danidomenech.dndlootforge.ui.utils.typeOrder
import com.danidomenech.dndlootforge.utils.ItemUtils
import com.danidomenech.dndlootforge.utils.ItemUtils.rarityOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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
        val allowedTables = ItemUtils.getTablesForPlayerLevel(level)
        val allowedRanges = allowedTables.mapNotNull { ItemUtils.lootTableRanges[it] }

        val filteredItems = allVendorItems.filter { item ->
            allowedRanges.any { range -> item.powerLevel in range }
        }

        // 🔽 Sort by item type and then by rarity
        val sortedItems = filteredItems.sortedWith(
            compareBy(
                { typeOrder.indexOf(it.type) },
                { rarityOrder.indexOf(it.rarity) }
            )
        )

        _vendorItems.value = sortedItems
    }
}