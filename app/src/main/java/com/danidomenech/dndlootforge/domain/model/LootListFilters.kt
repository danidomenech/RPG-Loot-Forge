package com.danidomenech.dndlootforge.domain.model

data class LootListFilters(
    val rarities: Set<ItemRarity> = emptySet()
)