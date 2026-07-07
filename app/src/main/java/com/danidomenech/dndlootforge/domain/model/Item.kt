package com.danidomenech.dndlootforge.domain.model

import androidx.annotation.StringRes

data class Item(
    val id: ItemId,
    @StringRes val nameResId: Int,
    val type: ItemType,
    val rarity: ItemRarity,
    @StringRes val descriptionResId: Int,
    @StringRes val descriptionExtraResId: Int? = null,
    val requiresAttunement: Boolean = false,
    val value: Int,
    val powerLevel: Int,
    val origin: ItemOrigin = ItemOrigin.BOOK,
    val overrideTables: List<LootTable>? = null,
    val vendorExclusive: Boolean = false,
    val lootExclusive: Boolean = false,
    val narrativeLootExclusive: Boolean = false
)