package com.danidomenech.dndlootforge.feature.lootlist

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootListFilters

data class LootListUiState(
    val items: List<Item> = emptyList(),
    val totalItems: List<Item> = emptyList(),
    val filters: LootListFilters = LootListFilters()
) {
    val hasActiveFilters: Boolean
        get() = filters.rarities.isNotEmpty()
}