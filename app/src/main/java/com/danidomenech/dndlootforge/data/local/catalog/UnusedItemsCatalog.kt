package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.ItemIds
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType

internal object UnusedItemsCatalog {

    val items = listOf(

        LocalItem(
            id = ItemIds.ARMOR_OF_THE_RISING_TEMPER,
            nameResId = R.string.armor_of_the_rising_temper,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_of_the_rising_temper_description,
            descriptionExtraResId = R.string.armor_of_the_rising_temper_description_extra,
            value = 850,
            powerLevel = 183,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.HELM_OF_MARTIAL_FORTUNE,
            nameResId = R.string.helm_of_martial_fortune,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.helm_of_martial_fortune_description,
            descriptionExtraResId = R.string.helm_of_martial_fortune_description_extra,
            value = 2000,
            powerLevel = 182,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_SKEWED_FORTUNE,
            nameResId = R.string.ring_of_the_skewed_fortune,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_the_skewed_fortune_description,
            descriptionExtraResId = R.string.ring_of_the_skewed_fortune_description_extra,
            value = 800,
            powerLevel = 181,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_FORAGER,
            nameResId = R.string.ring_of_the_forager,
            type = ItemType.RING,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.ring_of_the_forager_description,
            descriptionExtraResId = R.string.ring_of_the_forager_description_extra,
            value = 2200,
            powerLevel = 385,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_PRECISION,
            nameResId = R.string.ring_of_precision,
            type = ItemType.RING,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.ring_of_precision_description,
            descriptionExtraResId = R.string.ring_of_precision_description_extra,
            value = 20000,
            powerLevel = 490,
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_BLADE,
            nameResId = R.string.ring_of_the_blade,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_the_blade_description,
            descriptionExtraResId = R.string.ring_of_the_blade_description_extra,
            value = 5000,
            powerLevel = 390,
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_DEADEYE,
            nameResId = R.string.ring_of_the_dead_eye,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_the_dead_eye_description,
            descriptionExtraResId = R.string.ring_of_the_dead_eye_description_extra,
            value = 5000,
            powerLevel = 390,
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_ARCANE_PRECISION,
            nameResId = R.string.ring_of_arcane_precision,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_arcane_precision_description,
            descriptionExtraResId = R.string.ring_of_arcane_precision_description_extra,
            value = 5000,
            powerLevel = 390,
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

    )
}