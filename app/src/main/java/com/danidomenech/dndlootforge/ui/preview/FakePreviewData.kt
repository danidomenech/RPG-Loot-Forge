package com.danidomenech.dndlootforge.ui.preview

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.model.ItemRarity
import com.danidomenech.dndlootforge.data.model.ItemType

val fakeItems = listOf(
    Item(
        id = "healing_potion",
        nameResId = R.string.healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.COMMON,
        descriptionResId = R.string.healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 50,
        powerLevel = 50
    ),
    Item(
        id = "major_healing_potion",
        nameResId = R.string.greater_healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.UNCOMMON,
        descriptionResId = R.string.greater_healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 200,
        powerLevel = 50
    ),
    Item(
        id = "superior_healing_potion",
        nameResId = R.string.superior_healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.RARE,
        descriptionResId = R.string.superior_healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 500,
        powerLevel = 50
    ),
    Item(
        id = "supreme_healing_potion",
        nameResId = R.string.supreme_healing_potion,
        type = ItemType.POTION,
        rarity = ItemRarity.VERY_RARE,
        descriptionResId = R.string.supreme_healing_potion_description,
        descriptionExtraResId = R.string.healing_potion_description_extra,
        value = 2000,
        powerLevel = 50
    )
)