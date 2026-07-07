package com.danidomenech.dndlootforge.preview

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.ItemId
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType

val fakeItems = listOf(
    Item(
        id = ItemId("healing_potion"),
        nameResId = R.string.healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.COMMON,
        descriptionResId = R.string.healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 50,
        powerLevel = 50
    ),
    Item(
        id = ItemId("major_healing_potion"),
        nameResId = R.string.greater_healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.UNCOMMON,
        descriptionResId = R.string.greater_healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 200,
        powerLevel = 50
    ),
    Item(
        id = ItemId("superior_healing_potion"),
        nameResId = R.string.superior_healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.RARE,
        descriptionResId = R.string.superior_healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 500,
        powerLevel = 50
    ),
    Item(
        id = ItemId("supreme_healing_potion"),
        nameResId = R.string.supreme_healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.VERY_RARE,
        descriptionResId = R.string.supreme_healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 2000,
        powerLevel = 50
    )
)