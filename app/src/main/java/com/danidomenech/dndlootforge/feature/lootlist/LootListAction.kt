package com.danidomenech.dndlootforge.feature.lootlist

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootListFilters

sealed interface LootListAction {
    data class ItemClick(val item: Item) : LootListAction

    data class ApplyFilters(
        val filters: LootListFilters
    ) : LootListAction
}