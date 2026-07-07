package com.danidomenech.dndlootforge.data.local.model

import com.danidomenech.dndlootforge.domain.model.ItemId
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType
import com.danidomenech.dndlootforge.domain.model.LootTable

/**
 * Local representation of an item stored in the hardcoded catalog.
 *
 * This model is intentionally separated from the domain model so the data
 * source can evolve later into JSON, Room, or remote data without affecting
 * the rest of the app.
 */
data class LocalItem(
    val id: ItemId,
    val nameResId: Int,
    val type: ItemType,
    val rarity: ItemRarity,
    val descriptionResId: Int,
    val descriptionExtraResId: Int? = null,
    val requiresAttunement: Boolean? = null,
    val value: Int,
    val powerLevel: Int,
    val origin: ItemOrigin = ItemOrigin.HOMEBREW,
    val overrideTables: List<LootTable>? = null,
    val vendorExclusive: Boolean? = null,
    val lootExclusive: Boolean? = null,
    val narrativeLootExclusive: Boolean? = null
)