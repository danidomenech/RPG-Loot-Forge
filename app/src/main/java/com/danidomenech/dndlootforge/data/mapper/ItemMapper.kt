package com.danidomenech.dndlootforge.data.mapper

import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.Item

fun LocalItem.toDomain(): Item {
    return Item(
        id = id,
        nameResId = nameResId,
        type = type,
        rarity = rarity,
        descriptionResId = descriptionResId,
        descriptionExtraResId = descriptionExtraResId,
        requiresAttunement = requiresAttunement?: false,
        value = value,
        powerLevel = powerLevel,
        origin = origin,
        overrideTables = overrideTables?: emptyList(),
        vendorExclusive = vendorExclusive?: false,
        lootExclusive = lootExclusive?: false,
        narrativeLootExclusive = lootExclusive?: false
    )
}