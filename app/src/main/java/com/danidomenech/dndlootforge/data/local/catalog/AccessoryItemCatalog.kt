package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.ItemIds
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType

internal object AccessoryItemCatalog {

    val items = listOf(
        // RINGS
        LocalItem(
            id = ItemIds.RING_OF_SWIMMING,
            nameResId = R.string.ring_of_swimming,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_swimming_description,
            value = 3000,
            powerLevel = 191,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.RING_OF_JUMPING,
            nameResId = R.string.ring_of_jumping,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_jumping_description,
            value = 2500,
            powerLevel = 385,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.RING_OF_MIND_SHIELDING,
            nameResId = R.string.ring_of_mind_shielding,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_mind_shielding_description,
            value = 16000,
            powerLevel = 290,
            requiresAttunement = true,
            narrativeLootExclusive = true
        ),
        LocalItem(
            id = ItemIds.RING_OF_WARMTH,
            nameResId = R.string.ring_of_warmth,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_warmth_description,
            value = 1000,
            powerLevel = 390,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.RING_OF_WATER_WALKING,
            nameResId = R.string.ring_of_water_walking,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_water_walking_description,
            value = 1500,
            powerLevel = 390,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.STONE_OF_GOOD_LUCK,
            nameResId = R.string.stone_of_good_luck,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.stone_of_good_luck_description,
            value = 4200,
            powerLevel = 280,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.RING_OF_PROTECTION,
            nameResId = R.string.ring_of_protection,
            type = ItemType.RING,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.ring_of_protection_description,
            value = 3500,
            powerLevel = 390,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.THE_WHISPERING_PROMISE,
            nameResId = R.string.the_whispering_promise,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.the_whispering_promise_description,
            descriptionExtraResId = R.string.the_whispering_promise_description_extra,
            value = 1500,
            powerLevel = 280,
            lootExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3_EDITED
        ),
        LocalItem(
            id = ItemIds.RING_OF_FLINGING,
            nameResId = R.string.ring_of_flinging,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_flinging_description,
            descriptionExtraResId = R.string.ring_of_flinging_description_extra,
            value = 900,
            powerLevel = 170,
            vendorExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_BLOOD_MAGE,
            nameResId = R.string.ring_of_the_blood_mage,
            type = ItemType.RING,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.ring_of_the_blood_mage_description,
            descriptionExtraResId = R.string.ring_of_the_blood_mage_description_extra,
            value = 2200,
            powerLevel = 395,
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_LAST_GUARD,
            nameResId = R.string.ring_of_the_last_guard,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_the_last_guard_description,
            descriptionExtraResId = R.string.ring_of_the_last_guard_description_extra,
            value = 1500,
            powerLevel = 175,
            requiresAttunement = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_PRIMAL_HUNTER,
            nameResId = R.string.ring_of_the_primal_hunter,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_the_primal_hunter_description,
            descriptionExtraResId = R.string.ring_of_the_primal_hunter_description_extra,
            value = 2000,
            powerLevel = 285,
            requiresAttunement = true,
            origin = ItemOrigin.BG3_EDITED
        ),
        LocalItem(
            id = ItemIds.RING_OF_ENCHANTING_TALES,
            nameResId = R.string.ring_of_enchanting_tales,
            type = ItemType.RING,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.ring_of_enchanting_tales_description,
            descriptionExtraResId = R.string.ring_of_enchanting_tales_description_extra,
            value = 3200,
            powerLevel = 385,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.RING_OF_THE_HERMIT_CRAB,
            nameResId = R.string.ring_of_the_hermit_crab,
            type = ItemType.RING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ring_of_the_hermit_crab_description,
            descriptionExtraResId = R.string.ring_of_the_hermit_crab_description_extra,
            value = 2000,
            powerLevel = 285,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),

        // NECKLACES
        LocalItem(
            id = ItemIds.PERIAPT_OF_HEALTH,
            nameResId = R.string.periapt_of_health,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.periapt_of_health_description,
            value = 2500,
            powerLevel = 290,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.BROOCH_OF_SHIELDING,
            nameResId = R.string.brooch_of_shielding,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.brooch_of_shielding_description,
            value = 7500,
            powerLevel = 260,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.MEDALLION_OF_THOUGHTS,
            nameResId = R.string.medallion_of_thoughts,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.medallion_of_thoughts_description,
            value = 3000,
            powerLevel = 270,
            requiresAttunement = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.NECKLACE_OF_ADAPTATION,
            nameResId = R.string.necklace_of_adaptation,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.necklace_of_adaptation_description,
            value = 1500,
            powerLevel = 380,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.PERIAPT_OF_WOUND_CLOSURE,
            nameResId = R.string.periapt_of_wound_closure,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.periapt_of_wound_closure_description,
            value = 5000,
            powerLevel = 384,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.AMULET_OF_SILVANUS,
            nameResId = R.string.amulet_of_silvanus,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.amulet_of_silvanus_description,
            descriptionExtraResId = R.string.amulet_of_silvanus_description_extra,
            value = 1500,
            powerLevel = 280,
            lootExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.BROODMODERS_REVENGE,
            nameResId = R.string.broodmothers_revenge,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.broodmothers_revenge_description,
            descriptionExtraResId = R.string.broodmothers_revenge_description_extra,
            value = 1000,
            powerLevel = 180,
            lootExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3_EDITED
        ),
        LocalItem(
            id = ItemIds.SILVER_PENDANT,
            nameResId = R.string.silver_pendant,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.silver_pendant_description,
            descriptionExtraResId = R.string.silver_pendant_description_extra,
            value = 800,
            powerLevel = 180,
            lootExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.MOONDROP_PENDANT,
            nameResId = R.string.moondrop_pendant,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.moondrop_pendant_description,
            descriptionExtraResId = R.string.moondrop_pendant_description_extra,
            value = 1800,
            powerLevel = 181,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.TARNISHED_CHARM,
            nameResId = R.string.tarnished_charm,
            type = ItemType.NECKLACE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.tarnished_charm_description,
            descriptionExtraResId = R.string.tarnished_charm_description_extra,
            value = 350,
            powerLevel = 180,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
    )
}