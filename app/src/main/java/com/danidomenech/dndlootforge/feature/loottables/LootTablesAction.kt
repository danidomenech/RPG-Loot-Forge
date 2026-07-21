package com.danidomenech.dndlootforge.feature.loottables

import com.danidomenech.dndlootforge.domain.model.Item

sealed interface LootTablesAction {
    data class ShowOnlyGearChange(val showOnlyGear: Boolean) : LootTablesAction
    data class ItemClick(val item: Item) : LootTablesAction
}