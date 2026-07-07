package com.danidomenech.dndlootforge.domain.model

val ItemRarity.sortOrder: Int
    get() = when (this) {
        ItemRarity.COMMON -> 0
        ItemRarity.UNCOMMON -> 1
        ItemRarity.RARE -> 2
        ItemRarity.VERY_RARE -> 3
        ItemRarity.LEGENDARY -> 4
    }