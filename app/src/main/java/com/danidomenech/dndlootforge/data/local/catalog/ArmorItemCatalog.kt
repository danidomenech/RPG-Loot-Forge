package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.ItemIds
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType
import com.danidomenech.dndlootforge.domain.model.LootTable

internal object ArmorItemCatalog {

    val items = listOf(
        // GENERIC ARMORS
        LocalItem(
            id = ItemIds.MITHRAL_ARMOR,
            nameResId = R.string.mithral_armor,
            type = ItemType.ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.mithral_armor_description,
            descriptionExtraResId = R.string.mithral_armor_description_extra,
            value = 0,
            powerLevel = 182,
            lootExclusive = true
        ),

        // LIGHT ARMORS
        LocalItem(
            id = ItemIds.ARMOR_PADDED_PLUS_1,
            nameResId = R.string.armor_padded_plus_1,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_padded_plus_1_description,
            value = 600,
            powerLevel = 250,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.B)
        ),
        LocalItem(
            id = ItemIds.ARMOR_PADDED_PLUS_2,
            nameResId = R.string.armor_padded_plus_2,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_padded_plus_2_description,
            value = 2800,
            powerLevel = 350,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.C)
        ),
        LocalItem(
            id = ItemIds.ARMOR_PADDED_PLUS_3,
            nameResId = R.string.armor_padded_plus_3,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_padded_plus_3_description,
            value = 10000,
            powerLevel = 450,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_LEATHER_PLUS_1,
            nameResId = R.string.armor_leather_plus_1,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_leather_plus_1_description,
            value = 800,
            powerLevel = 350,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.C)
        ),
        LocalItem(
            id = ItemIds.ARMOR_LEATHER_PLUS_2,
            nameResId = R.string.armor_leather_plus_2,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_leather_plus_2_description,
            value = 3400,
            powerLevel = 450,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_LEATHER_PLUS_3,
            nameResId = R.string.armor_leather_plus_3,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_leather_plus_3_description,
            value = 11000,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_STUDDED_LEATHER_PLUS_1,
            nameResId = R.string.armor_studded_leather_plus_1,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_studded_leather_plus_1_description,
            value = 1000,
            powerLevel = 450,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_STUDDED_LEATHER_PLUS_2,
            nameResId = R.string.armor_studded_leather_plus_2,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_studded_leather_plus_2_description,
            value = 4000,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_STUDDED_LEATHER_PLUS_3,
            nameResId = R.string.armor_studded_leather_plus_3,
            type = ItemType.LIGHT_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_studded_leather_plus_3_description,
            value = 12000,
            powerLevel = 650,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),

        // MEDIUM ARMORS
        LocalItem(
            id = ItemIds.ARMOR_HIDE_PLUS_1,
            nameResId = R.string.armor_hide_plus_1,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_hide_plus_1_description,
            value = 1200,
            powerLevel = 350,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.C)
        ),
        LocalItem(
            id = ItemIds.ARMOR_HIDE_PLUS_2,
            nameResId = R.string.armor_hide_plus_2,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_hide_plus_2_description,
            value = 4400,
            powerLevel = 450,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_HIDE_PLUS_3,
            nameResId = R.string.armor_hide_plus_3,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_hide_plus_3_description,
            value = 16000,
            powerLevel = 550,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_CHAIN_SHIRT_PLUS_1,
            nameResId = R.string.armor_chain_shirt_plus_1,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_chain_shirt_plus_1_description,
            value = 1400,
            powerLevel = 350,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.C)
        ),
        LocalItem(
            id = ItemIds.ARMOR_CHAIN_SHIRT_PLUS_2,
            nameResId = R.string.armor_chain_shirt_plus_2,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_chain_shirt_plus_2_description,
            value = 4800,
            powerLevel = 450,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_CHAIN_SHIRT_PLUS_3,
            nameResId = R.string.armor_chain_shirt_plus_3,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_chain_shirt_plus_3_description,
            value = 18000,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_SCALE_MAIL_PLUS_1,
            nameResId = R.string.armor_scale_mail_plus_1,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_scale_mail_plus_1_description,
            value = 1600,
            powerLevel = 450,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_SCALE_MAIL_PLUS_2,
            nameResId = R.string.armor_scale_mail_plus_2,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_scale_mail_plus_2_description,
            value = 5200,
            powerLevel = 550,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_SCALE_MAIL_PLUS_3,
            nameResId = R.string.armor_scale_mail_plus_3,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_scale_mail_plus_3_description,
            value = 20000,
            powerLevel = 650,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.ARMOR_BREASTPLATE_PLUS_1,
            nameResId = R.string.armor_breastplate_plus_1,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_breastplate_plus_1_description,
            value = 1800,
            powerLevel = 450,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_BREASTPLATE_PLUS_2,
            nameResId = R.string.armor_breastplate_plus_2,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_breastplate_plus_2_description,
            value = 5600,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_BREASTPLATE_PLUS_3,
            nameResId = R.string.armor_breastplate_plus_3,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_breastplate_plus_3_description,
            value = 22000,
            powerLevel = 650,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.ARMOR_HALF_PLATE_PLUS_1,
            nameResId = R.string.armor_half_plate_plus_1,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_half_plate_plus_1_description,
            value = 2000,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_HALF_PLATE_PLUS_2,
            nameResId = R.string.armor_half_plate_plus_2,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_half_plate_plus_2_description,
            value = 6000,
            powerLevel = 650,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.ARMOR_HALF_PLATE_PLUS_3,
            nameResId = R.string.armor_half_plate_plus_3,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_half_plate_plus_3_description,
            value = 24000,
            powerLevel = 750,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.G)
        ),
        LocalItem(
            id = ItemIds.ARMOR_OF_ADAMANTINE_SCALE_MAIL_UNCOMMON,
            nameResId = R.string.armor_of_adamantine_scale_mail_uncommon,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_of_adamantine_scale_mail_uncommon_description,
            descriptionExtraResId = R.string.armor_of_adamantine_description_extra,
            value = 10000,
            powerLevel = 371,
            narrativeLootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.ARMOR_OF_ADAMANTINE_SCALE_MAIL_RARE,
            nameResId = R.string.armor_of_adamantine_scale_mail_rare,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_of_adamantine_scale_mail_rare_description,
            descriptionExtraResId = R.string.armor_of_adamantine_description_extra,
            value = 17000,
            powerLevel = 471,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.ARMOR_OF_ADAMANTINE_SCALE_MAIL_VERY_RARE,
            nameResId = R.string.armor_of_adamantine_scale_mail_very_rare,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_of_adamantine_scale_mail_very_rare_description,
            descriptionExtraResId = R.string.armor_of_adamantine_description_extra,
            value = 25000,
            powerLevel = 571,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.HEDGE_WANDERER_ARMOR,
            nameResId = R.string.hedge_wanderer_armor,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.hedge_wanderer_armor_description,
            descriptionExtraResId = R.string.hedge_wanderer_armor_description_extra,
            value = 800,
            powerLevel = 170,
            vendorExclusive = true,
            origin = ItemOrigin.BG3_EDITED
        ),
        LocalItem(
            id = ItemIds.THE_OAK_FATHERS_EMBRACE,
            nameResId = R.string.the_oak_fathers_embrace,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.the_oak_fathers_embrace_description,
            descriptionExtraResId = R.string.the_oak_fathers_embrace_description_extra,
            value = 1500,
            powerLevel = 280,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.SCALE_MAIL_OF_THE_FINAL_RESISTANCE,
            nameResId = R.string.scale_mail_armor_of_the_final_resistance,
            type = ItemType.MEDIUM_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.scale_mail_armor_of_the_final_resistance_description,
            descriptionExtraResId = R.string.scale_mail_armor_of_the_final_resistance_description_extra,
            value = 3500,
            powerLevel = 383,
            origin = ItemOrigin.HOMEBREW
        ),

        // HEAVY ARMORS
        LocalItem(
            id = ItemIds.ARMOR_RING_MAIL_PLUS_1,
            nameResId = R.string.armor_ring_mail_plus_1,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_ring_mail_plus_1_description,
            value = 2800,
            powerLevel = 350,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.C)
        ),
        LocalItem(
            id = ItemIds.ARMOR_RING_MAIL_PLUS_2,
            nameResId = R.string.armor_ring_mail_plus_2,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_ring_mail_plus_2_description,
            value = 8800,
            powerLevel = 450,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_RING_MAIL_PLUS_3,
            nameResId = R.string.armor_ring_mail_plus_3,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_ring_mail_plus_3_description,
            value = 26000,
            powerLevel = 550,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_CHAIN_MAIL_PLUS_1,
            nameResId = R.string.armor_chain_mail_plus_1,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_chain_mail_plus_1_description,
            value = 3000,
            powerLevel = 450,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.ARMOR_CHAIN_MAIL_PLUS_2,
            nameResId = R.string.armor_chain_mail_plus_2,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_chain_mail_plus_2_description,
            value = 9200,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_CHAIN_MAIL_PLUS_3,
            nameResId = R.string.armor_chain_mail_plus_3,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_chain_mail_plus_3_description,
            value = 28000,
            powerLevel = 650,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.ARMOR_SPLINT_PLUS_1,
            nameResId = R.string.armor_splint_plus_1,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_splint_plus_1_description,
            value = 3200,
            powerLevel = 550,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.ARMOR_SPLINT_PLUS_2,
            nameResId = R.string.armor_splint_plus_2,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_splint_plus_2_description,
            value = 9600,
            powerLevel = 650,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.ARMOR_SPLINT_PLUS_3,
            nameResId = R.string.armor_splint_plus_3,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_splint_plus_3_description,
            value = 30000,
            powerLevel = 750,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.G)
        ),
        LocalItem(
            id = ItemIds.ARMOR_PLATE_PLUS_1,
            nameResId = R.string.armor_plate_plus_1,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_plate_plus_1_description,
            value = 3400,
            powerLevel = 650,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.ARMOR_PLATE_PLUS_2,
            nameResId = R.string.armor_plate_plus_2,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_plate_plus_2_description,
            value = 10000,
            powerLevel = 750,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.G)
        ),
        LocalItem(
            id = ItemIds.ARMOR_PLATE_PLUS_3,
            nameResId = R.string.armor_plate_plus_3,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_plate_plus_3_description,
            value = 32000,
            powerLevel = 850,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.H)
        ),
        LocalItem(
            id = ItemIds.ARMOR_OF_ADAMANTINE_SPLINT_ARMOR_UNCOMMON,
            nameResId = R.string.armor_of_adamantine_splint_armor_uncommon,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.armor_of_adamantine_splint_armor_uncommon_description,
            descriptionExtraResId = R.string.armor_of_adamantine_description_extra,
            value = 14000,
            powerLevel = 372,
            narrativeLootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.ARMOR_OF_ADAMANTINE_SPLINT_ARMOR_RARE,
            nameResId = R.string.armor_of_adamantine_splint_armor_rare,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.armor_of_adamantine_splint_armor_rare_description,
            descriptionExtraResId = R.string.armor_of_adamantine_description_extra,
            value = 20000,
            powerLevel = 472,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.ARMOR_OF_ADAMANTINE_SPLINT_ARMOR_VERY_RARE,
            nameResId = R.string.armor_of_adamantine_splint_armor_very_rare,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.armor_of_adamantine_splint_armor_very_rare_description,
            descriptionExtraResId = R.string.armor_of_adamantine_description_extra,
            value = 28000,
            powerLevel = 572,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.SPLINT_ARMOR_OF_THE_FINAL_RESISTANCE,
            nameResId = R.string.splint_armor_of_the_final_resistance,
            type = ItemType.HEAVY_ARMOR,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.splint_armor_of_the_final_resistance_description,
            descriptionExtraResId = R.string.splint_armor_of_the_final_resistance_description_extra,
            value = 4000,
            powerLevel = 384,
            origin = ItemOrigin.HOMEBREW
        ),

        // CLOTHING
        LocalItem(
            id = ItemIds.ROBE_OF_SUMMER,
            nameResId = R.string.robe_of_summer,
            type = ItemType.CLOTHING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.robe_of_summer_description,
            descriptionExtraResId = R.string.robe_of_summer_description_extra,
            value = 1500,
            powerLevel = 380,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.POISONERS_ROBE,
            nameResId = R.string.poisoners_robe,
            type = ItemType.CLOTHING,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.poisoners_robe_description,
            descriptionExtraResId = R.string.poisoners_robe_description_extra,
            value = 500,
            powerLevel = 180,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),

        // SHIELDS
        LocalItem(
            id = ItemIds.SHIELD_PLUS_1,
            nameResId = R.string.shield_plus_1,
            type = ItemType.SHIELD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.shield_plus_1_description,
            value = 1500,
            powerLevel = 450,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.SHIELD_PLUS_2,
            nameResId = R.string.shield_plus_2,
            type = ItemType.SHIELD,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.shield_plus_2_description,
            value = 6000,
            powerLevel = 550,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.SHIELD_PLUS_3,
            nameResId = R.string.shield_plus_3,
            type = ItemType.SHIELD,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.shield_plus_3_description,
            value = 24000,
            powerLevel = 650,
            overrideTables = listOf(LootTable.F)
        ),
        LocalItem(
            id = ItemIds.SAFEGUARD_SHIELD,
            nameResId = R.string.safeguard_shield,
            type = ItemType.SHIELD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.safeguard_shield_description,
            descriptionExtraResId = R.string.safeguard_shield_description_extra,
            value = 4500,
            powerLevel = 290,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.GLOWING_SHIELD,
            nameResId = R.string.glowing_shield,
            type = ItemType.SHIELD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.glowing_shield_description,
            descriptionExtraResId = R.string.glowing_shield_description_extra,
            value = 3000,
            powerLevel = 281,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.SHIELD_OF_DISTRACTION,
            nameResId = R.string.shield_of_distraction,
            type = ItemType.SHIELD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.shield_of_distraction_description,
            descriptionExtraResId = R.string.shield_of_distraction_description_extra,
            value = 900,
            powerLevel = 180,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // HELMETS
        LocalItem(
            id = ItemIds.CAP_OF_WATER_BREATHING,
            nameResId = R.string.cap_of_water_breathing,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.cap_of_water_breathing_description,
            value = 1000,
            powerLevel = 190,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.GOGGLES_OF_NIGHT,
            nameResId = R.string.goggles_of_night,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.goggles_of_night_description,
            value = 1500,
            powerLevel = 190,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.HELM_OF_COMPREHENDING_LANGUAGES,
            nameResId = R.string.helm_of_comprehending_languages,
            type = ItemType.HELMET,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.helm_of_comprehending_languages_description,
            value = 4000,
            powerLevel = 395,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.EYES_OF_MINUTE_SEEING,
            nameResId = R.string.eyes_of_minute_seeing,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.eyes_of_minute_seeing_description,
            descriptionExtraResId = R.string.eyes_of_minute_seeing_description_extra,
            value = 2500,
            powerLevel = 290,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.HAT_OF_DISGUISE,
            nameResId = R.string.hat_of_disguise,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.hat_of_disguise_description,
            value = 5000,
            powerLevel = 265,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.CIRCLET_OF_BLASTING,
            nameResId = R.string.circlet_of_blasting,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.circlet_of_blasting_description,
            value = 1500,
            powerLevel = 280,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.EYES_OF_CHARMING,
            nameResId = R.string.eyes_of_charming,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.eyes_of_charming_description,
            descriptionExtraResId = R.string.eyes_of_charming_description_extra,
            value = 3000,
            powerLevel = 380,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.EYES_OF_THE_EAGLE,
            nameResId = R.string.eyes_of_the_eagle,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.eyes_of_the_eagle_description,
            descriptionExtraResId = R.string.eyes_of_the_eagle_description_extra,
            value = 2500,
            powerLevel = 280,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.HEADBAND_OF_INTELLECT,
            nameResId = R.string.headband_of_intellect,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.headband_of_intellect_description,
            value = 8000,
            powerLevel = 383,
            requiresAttunement = true,
            narrativeLootExclusive = true
        ),
        LocalItem(
            id = ItemIds.HELM_OF_TELEPATHY,
            nameResId = R.string.helm_of_telepathy,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.helm_of_telepathy_description,
            value = 12000,
            powerLevel = 383,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.CAP_OF_CURING,
            nameResId = R.string.cap_of_curing,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.cap_of_curing_description,
            descriptionExtraResId = R.string.cap_of_curing_description_extra,
            value = 1000,
            powerLevel = 280,
            vendorExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.WAPIRAS_CROWN,
            nameResId = R.string.wapiras_crown,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.wapiras_crown_description,
            descriptionExtraResId = R.string.wapiras_crown_description_extra,
            value = 1200,
            powerLevel = 180,
            lootExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.HOOD_OF_AWAKENING_AWARENESS,
            nameResId = R.string.hood_of_awakened_awareness,
            type = ItemType.HELMET,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.hood_of_awakened_awareness_description,
            descriptionExtraResId = R.string.hood_of_awakened_awareness_description_extra,
            value = 1500,
            powerLevel = 181,
            origin = ItemOrigin.BG3
        ),

        // GLOVES
        LocalItem(
            id = ItemIds.BRACERS_OF_ARCHERY,
            nameResId = R.string.bracers_of_archery,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.bracers_of_archery_description,
            value = 2000,
            powerLevel = 260, // original 360
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.GAUNTLETS_OF_OGRE_POWER,
            nameResId = R.string.gauntlets_of_ogre_power,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gauntlets_of_ogre_power_description,
            value = 8000,
            powerLevel = 395,
            requiresAttunement = true,
            narrativeLootExclusive = true
        ),
        LocalItem(
            id = ItemIds.GLOVES_OF_MISSILE_SNARING,
            nameResId = R.string.gloves_of_missile_snaring,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gloves_of_missile_snaring_description,
            descriptionExtraResId = R.string.gloves_of_missile_snaring_description_extra,
            value = 3000,
            powerLevel = 281,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.GLOVES_OF_SWIMMING_AND_CLIMBING,
            nameResId = R.string.gloves_of_swimming_and_climbing,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gloves_of_swimming_and_climbing_description,
            value = 2000,
            powerLevel = 265,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.GLOVES_OF_THIEVERY,
            nameResId = R.string.gloves_of_thievery,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gloves_of_thievery_description,
            descriptionExtraResId = R.string.gloves_of_thievery_description_extra,
            value = 5000,
            powerLevel = 282,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.HELLRIDERS_PRIDE,
            nameResId = R.string.hellriders_pride,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.hellriders_pride_description,
            descriptionExtraResId = R.string.hellriders_pride_description_extra,
            value = 1200,
            powerLevel = 280,
            lootExclusive = true,
            requiresAttunement = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.GLOVES_OF_HEROISM,
            nameResId = R.string.gloves_of_heroism,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gloves_of_heroism_description,
            descriptionExtraResId = R.string.gloves_of_heroism_description_extra,
            value = 1000,
            powerLevel = 181,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.STEADYHAND_GLOVES,
            nameResId = R.string.steadyhand_gloves,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.steadyhand_gloves_description,
            descriptionExtraResId = R.string.steadyhand_gloves_description_extra,
            value = 750,
            powerLevel = 180,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.GLOVES_OF_MONSTERS_BANE,
            nameResId = R.string.gloves_of_monsters_bane,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gloves_of_monsters_bane_description,
            descriptionExtraResId = R.string.gloves_of_monsters_bane_description_extra,
            value = 2000,
            powerLevel = 180,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.GLOVES_OF_THE_QUICK_DRAW,
            nameResId = R.string.gloves_of_the_quick_draw,
            type = ItemType.GLOVES,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gloves_of_the_quick_draw_description,
            descriptionExtraResId = R.string.gloves_of_the_quick_draw_description_extra,
            value = 1500,
            powerLevel = 181,
            origin = ItemOrigin.BG3
        ),

        // BOOTS
        LocalItem(
            id = ItemIds.BOOTS_OF_ELVENKIND,
            nameResId = R.string.boots_of_elvenkind,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.boots_of_elvenkind_description,
            value = 2500,
            powerLevel = 259, // original 360
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.BOOTS_OF_STRIDING_AND_SPRINGING,
            nameResId = R.string.boots_of_striding_and_springing,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.boots_of_striding_and_springing_description,
            value = 5000,
            powerLevel = 258, // original 360
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.SLIPPERS_OF_SPIDER_CLIMBING,
            nameResId = R.string.slippers_of_spider_climbing,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.slippers_of_spider_climbing_description,
            value = 5000,
            powerLevel = 264,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.BOOTS_OF_THE_WINTERLANDS,
            nameResId = R.string.boots_of_the_winterlands,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.boots_of_the_winterlands_description,
            descriptionExtraResId = R.string.boots_of_the_winterlands_description_extra,
            value = 10000,
            powerLevel = 380,
            requiresAttunement = true,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.WINGED_BOOTS,
            nameResId = R.string.winged_boots,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.stone_of_good_luck_description,
            value = 8000,
            powerLevel = 490,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.BOOTS_OF_THE_SWIFT_STALKER,
            nameResId = R.string.boots_of_the_swift_stalker,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.boots_of_the_swift_stalker_description,
            descriptionExtraResId = R.string.boots_of_the_swift_stalker_description_extra,
            value = 2500,
            powerLevel = 285,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.FEATHERLIGHT_BOOTS,
            nameResId = R.string.featherlight_boots,
            type = ItemType.BOOTS,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.featherlight_boots_description,
            descriptionExtraResId = R.string.featherlight_boots_description_extra,
            value = 2000,
            powerLevel = 280,
            origin = ItemOrigin.BG3
        ),

        // CLOAKS
        LocalItem(
            id = ItemIds.CLOAK_OF_THE_MANTA_RAY,
            nameResId = R.string.cloak_of_the_manta_ray,
            type = ItemType.CLOAK,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.cloak_of_the_manta_ray_description,
            value = 6000,
            powerLevel = 290,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.CLOAK_OF_ELVENKIND,
            nameResId = R.string.cloak_of_elvenkind,
            type = ItemType.CLOAK,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.cloak_of_elvenkind_description,
            value = 5000,
            powerLevel = 258,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.CLOAK_OF_PROTECTION,
            nameResId = R.string.cloak_of_protection,
            type = ItemType.CLOAK,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.cloak_of_protection_description,
            value = 3500,
            powerLevel = 260,
            requiresAttunement = true,
            lootExclusive = true
        ),
    )
}