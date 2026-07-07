package com.danidomenech.dndlootforge.domain.model

val ItemCategory.isGear: Boolean
    get() = this in gearCategories

private val gearCategories = setOf(
    ItemCategory.WEAPON,
    ItemCategory.ARMOR,
    ItemCategory.ACCESSORY,
    ItemCategory.MAGICAL_FOCUS
)