package com.danidomenech.dndlootforge.feature.lootlist

import com.danidomenech.dndlootforge.domain.model.Item

sealed interface LootListAction {
    data class ItemClick(val item: Item) : LootListAction
}