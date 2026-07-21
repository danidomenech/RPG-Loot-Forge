package com.danidomenech.dndlootforge.feature.narrativelootlist

import com.danidomenech.dndlootforge.domain.model.Item

data class NarrativeLootListUiState(
    val items: List<Item> = emptyList()
)