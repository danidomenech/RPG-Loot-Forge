package com.danidomenech.dndlootforge.feature.lootlist

import com.danidomenech.dndlootforge.domain.model.Item

data class LootListUiState(
    val items: List<Item> = emptyList()
)