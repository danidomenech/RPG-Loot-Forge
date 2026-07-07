package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.ItemIds
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType

internal object MiscItemCatalog {

    val items = listOf(
        LocalItem(
            id = ItemIds.DRIFTGLOVE,
            nameResId = R.string.driftglove,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.driftglove_description,
            value = 750,
            powerLevel = 95,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.SADDLE_OF_THE_CAVALIER,
            nameResId = R.string.saddle_of_the_cavalier,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.saddle_of_the_cavalier_description,
            value = 2000,
            powerLevel = 395,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.HORSESHOES_OF_SPEED,
            nameResId = R.string.horseshoes_of_speed,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.horseshoes_of_speed_description,
            descriptionExtraResId = R.string.horseshoes_of_speed_description_extra,
            value = 5000,
            powerLevel = 290,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.SENDING_STONES,
            nameResId = R.string.sending_stones,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.sending_stones_description,
            descriptionExtraResId = R.string.sending_stones_description_extra,
            value = 2000,
            powerLevel = 292,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.HORSESHOES_OF_A_ZEPHYR,
            nameResId = R.string.horseshoes_of_a_zephyr,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.horseshoes_of_a_zephyr_description,
            descriptionExtraResId = R.string.horseshoes_of_a_zephyr_description_extra,
            value = 7500,
            powerLevel = 380,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.BROOM_OF_FLYING,
            nameResId = R.string.broom_of_flying,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.broom_of_flying_description,
            value = 8000,
            powerLevel = 370,
            narrativeLootExclusive = true
        ),
        LocalItem(
            id = ItemIds.PEARL_OF_POWER,
            nameResId = R.string.pearl_of_power,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.pearl_of_power_description,
            value = 6000,
            powerLevel = 262
        ),
        LocalItem(
            id = ItemIds.PEARL_OF_POWER_CRACKED,
            nameResId = R.string.pearl_of_power_cracked,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.pearl_of_power_cracked_description,
            descriptionExtraResId = R.string.pearl_of_power_cracked_description_extra,
            origin = ItemOrigin.BOOK_EDITED,
            value = 2000,
            powerLevel = 162,
            narrativeLootExclusive = true
        ),
        LocalItem(
            id = ItemIds.EVERSMOKING_BOTTLE,
            nameResId = R.string.eversmoking_bottle,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.eversmoking_bottle_description,
            descriptionExtraResId = R.string.eversmoking_bottle_description_extra,
            value = 6000,
            powerLevel = 380,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.PIPES_OF_HAUNTING,
            nameResId = R.string.pipes_of_haunting,
            type = ItemType.MAGICAL_TOOL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.pipes_of_haunting_description,
            value = 6000,
            powerLevel = 385
        ),
    )
}