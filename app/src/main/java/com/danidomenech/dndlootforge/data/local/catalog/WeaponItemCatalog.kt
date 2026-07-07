package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.ItemIds
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType
import com.danidomenech.dndlootforge.domain.model.LootTable

internal object WeaponItemCatalog {

    val items = listOf(
        // GENERIC WEAPONS
        LocalItem(
            id = ItemIds.WEAPON_PLUS_1,
            nameResId = R.string.weapon_plus_1,
            type = ItemType.WEAPON,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.weapon_plus_1_description,
            value = 0,
            powerLevel = 325,
            overrideTables = listOf(LootTable.C)
        ),
        LocalItem(
            id = ItemIds.WEAPON_PLUS_2,
            nameResId = R.string.weapon_plus_2,
            type = ItemType.WEAPON,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.weapon_plus_2_description,
            value = 0,
            powerLevel = 425,
            overrideTables = listOf(LootTable.D)
        ),
        LocalItem(
            id = ItemIds.WEAPON_PLUS_3,
            nameResId = R.string.weapon_plus_3,
            type = ItemType.WEAPON,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.weapon_plus_3_description,
            value = 0,
            powerLevel = 525,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.WEAPON_OF_WARNING,
            nameResId = R.string.weapon_of_warning,
            type = ItemType.WEAPON,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.weapon_of_warning_description,
            value = 15000,
            powerLevel = 470,
            requiresAttunement = true,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),

        // DAGGERS
        LocalItem(
            id = ItemIds.VIPERS_FANG,
            nameResId = R.string.vipers_fang,
            type = ItemType.DAGGER,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.vipers_fang_description,
            descriptionExtraResId = R.string.vipers_fang_description_extra,
            value = 3600,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // SHORT SWORDS
        LocalItem(
            id = ItemIds.STORMFANG,
            nameResId = R.string.stormfang,
            type = ItemType.SHORT_SWORD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.stormfang_description,
            descriptionExtraResId = R.string.stormfang_description_extra,
            value = 3700,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // LONG SWORDS
        LocalItem(
            id = ItemIds.SWORD_OF_JUSTICE,
            nameResId = R.string.sword_of_justice,
            type = ItemType.LONG_SWORD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.sword_of_justice_description,
            descriptionExtraResId = R.string.sword_of_justice_description_extra,
            value = 750,
            powerLevel = 181,
            narrativeLootExclusive = true,
            origin = ItemOrigin.BG3_EDITED
        ),
        LocalItem(
            id = ItemIds.SWORD_OF_JUSTICE_RARE,
            nameResId = R.string.sword_of_justice_rare,
            type = ItemType.LONG_SWORD,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.sword_of_justice_rare_description,
            descriptionExtraResId = R.string.sword_of_justice_description_extra,
            value = 4000,
            powerLevel = 381,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.SWORD_OF_JUSTICE_VERY_RARE,
            nameResId = R.string.sword_of_justice_very_rare,
            type = ItemType.LONG_SWORD,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.sword_of_justice_very_rare_description,
            descriptionExtraResId = R.string.sword_of_justice_description_extra,
            value = 15000,
            powerLevel = 481,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.SWORD_OF_JUSTICE_LEGENDARY,
            nameResId = R.string.sword_of_justice_legendary,
            type = ItemType.LONG_SWORD,
            rarity = ItemRarity.LEGENDARY,
            descriptionResId = R.string.sword_of_justice_legendary_description,
            descriptionExtraResId = R.string.sword_of_justice_description_extra,
            value = 70000,
            powerLevel = 681,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.FROSTBITE_BLADE,
            nameResId = R.string.frostbite_blade,
            type = ItemType.LONG_SWORD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.frostbite_blade_description,
            descriptionExtraResId = R.string.frostbite_blade_description_extra,
            value = 3800,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // GREATSWORDS
        LocalItem(
            id = ItemIds.SWORD_OF_THE_AVENGER,
            nameResId = R.string.sword_of_the_avenger,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.sword_of_the_avenger_description,
            descriptionExtraResId = R.string.sword_of_the_avenger_description_extra,
            value = 1000,
            powerLevel = 281,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.SWORD_OF_THE_AVENGER_RARE,
            nameResId = R.string.sword_of_the_avenger_rare,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.sword_of_the_avenger_rare_description,
            descriptionExtraResId = R.string.sword_of_the_avenger_description_extra,
            value = 4000,
            powerLevel = 381,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.SWORD_OF_THE_AVENGER_VERY_RARE,
            nameResId = R.string.sword_of_the_avenger_very_rare,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.sword_of_the_avenger_very_rare_description,
            descriptionExtraResId = R.string.sword_of_the_avenger_description_extra,
            value = 15000,
            powerLevel = 481,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.SWORD_OF_THE_AVENGER_LEGENDARY,
            nameResId = R.string.sword_of_the_avenger_legendary,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.LEGENDARY,
            descriptionResId = R.string.sword_of_the_avenger_legendary_description,
            descriptionExtraResId = R.string.sword_of_the_avenger_description_extra,
            value = 75000,
            powerLevel = 681,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.EVERBURN_BLADE,
            nameResId = R.string.everburn_blade,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.everburn_blade_description,
            descriptionExtraResId = R.string.everburn_blade_description_extra,
            value = 4000,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.TITAN_FANG,
            nameResId = R.string.titan_fang,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.titan_fang_description,
            descriptionExtraResId = R.string.titan_fang_description_extra,
            value = 15000,
            powerLevel = 495,
            requiresAttunement = true,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.TITAN_FANG_LEGENDARY,
            nameResId = R.string.titan_fang_legendary,
            type = ItemType.GREATSWORD,
            rarity = ItemRarity.LEGENDARY,
            descriptionResId = R.string.titan_fang_legendary_description,
            descriptionExtraResId = R.string.titan_fang_description_extra,
            value = 70000,
            powerLevel = 695,
            requiresAttunement = true,
            narrativeLootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // HAND AXE
        LocalItem(
            id = ItemIds.DRAGONS_GRASP,
            nameResId = R.string.dragons_grasp,
            type = ItemType.HAND_AXE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.dragons_grasp_description,
            descriptionExtraResId = R.string.dragons_grasp_description_extra,
            value = 800,
            powerLevel = 180,
            vendorExclusive = true,
            origin = ItemOrigin.BG3
        ),

        // BATTLE AXES
        LocalItem(
            id = ItemIds.CORRODING_EDGE,
            nameResId = R.string.corroding_edge,
            type = ItemType.BATTLE_AXE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.corroding_edge_description,
            descriptionExtraResId = R.string.corroding_edge_description_extra,
            value = 3800,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // GREATAXES
        LocalItem(
            id = ItemIds.REAPERS_CLEAVER,
            nameResId = R.string.reapers_cleaver,
            type = ItemType.GREATAXE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.reapers_cleaver_description,
            descriptionExtraResId = R.string.reapers_cleaver_description_extra,
            value = 4000,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),
        LocalItem(
            id = ItemIds.IRONCLEAVE_AXE,
            nameResId = R.string.ironcleave_axe,
            type = ItemType.GREATAXE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ironcleave_axe_description,
            descriptionExtraResId = R.string.ironcleave_axe_description_extra,
            value = 1800,
            powerLevel = 295,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // WARHAMMERS
        LocalItem(
            id = ItemIds.THUNDERMAUL,
            nameResId = R.string.thundermaul,
            type = ItemType.WARHAMMER,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.thundermaul_description,
            descriptionExtraResId = R.string.thundermaul_description_extra,
            value = 3800,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // MAULS
        LocalItem(
            id = ItemIds.HAMMER_OF_THE_RIFT,
            nameResId = R.string.hammer_of_the_rift,
            type = ItemType.MAUL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.hammer_of_the_rift_description,
            descriptionExtraResId = R.string.hammer_of_the_rift_description_extra,
            value = 4000,
            powerLevel = 283,
            lootExclusive = true,
            origin = ItemOrigin.HOMEBREW
        ),

        // JAVELINS
        LocalItem(
            id = ItemIds.JAVELIN_OF_LIGHTNING,
            nameResId = R.string.javelin_of_lightning,
            type = ItemType.JAVELIN,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.javelin_of_lightning_description,
            value = 1500,
            powerLevel = 261,
            lootExclusive = true
        ),

        // TRIDENTS
        LocalItem(
            id = ItemIds.TRIDENT_OF_FISH_COMMAND,
            nameResId = R.string.trident_of_fish_command,
            type = ItemType.TRIDENT,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.trident_of_fish_command_description,
            value = 800,
            powerLevel = 367,
            requiresAttunement = true,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),

        // SHORT BOWS
        LocalItem(
            id = ItemIds.HUNTING_SHORTBOW,
            nameResId = R.string.hunting_shortbow,
            type = ItemType.SHORT_BOW,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.hunting_shortbow_description,
            descriptionExtraResId = R.string.hunting_shortbow_description_extra,
            value = 1500,
            powerLevel = 281,
            lootExclusive = true,
            origin = ItemOrigin.BG3_EDITED
        ),

        // LONG BOWS
        LocalItem(
            id = ItemIds.SPELLTHIEF,
            nameResId = R.string.spellthief,
            type = ItemType.LONG_BOW,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.spellthief_description,
            descriptionExtraResId = R.string.spellthief_description_extra,
            value = 950,
            powerLevel = 170,
            vendorExclusive = true,
            origin = ItemOrigin.BG3
        ),

        // HEAVY CROSSBOWS
        LocalItem(
            id = ItemIds.GANDRELS_ASPIRATION,
            nameResId = R.string.gandrels_aspiration,
            type = ItemType.HEAVY_CROSSBOW,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.gandrels_aspiration_description,
            descriptionExtraResId = R.string.gandrels_aspiration_description_extra,
            value = 1000,
            powerLevel = 280,
            lootExclusive = true,
            origin = ItemOrigin.BG3_EDITED
        ),

        // WANDS
        LocalItem(
            id = ItemIds.WAND_OF_MAGIC_DETECTION,
            nameResId = R.string.wand_of_magic_detection,
            type = ItemType.WAND,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.wand_of_magic_detection_description,
            value = 500,
            powerLevel = 195,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.WAND_OF_SECRETS,
            nameResId = R.string.wand_of_secrets,
            type = ItemType.WAND,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.wand_of_secrets_description,
            value = 500,
            powerLevel = 195,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.WAND_OF_MAGIC_MISSILES,
            nameResId = R.string.wand_of_magic_missiles,
            type = ItemType.WAND,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.wand_of_magic_missiles_description,
            value = 8000,
            powerLevel = 368,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.WAND_OF_THE_WAR_MAGE_PLUS_1,
            nameResId = R.string.wand_of_the_war_mage_plus_1,
            type = ItemType.WAND,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.wand_of_the_war_mage_plus_1_description,
            value = 1200,
            powerLevel = 369,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.WAND_OF_THE_WAR_MAGE_PLUS_2,
            nameResId = R.string.wand_of_the_war_mage_plus_2,
            type = ItemType.WAND,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.wand_of_the_war_mage_plus_2_description,
            value = 4800,
            powerLevel = 469,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.WAND_OF_THE_WAR_MAGE_PLUS_3,
            nameResId = R.string.wand_of_the_war_mage_plus_3,
            type = ItemType.WAND,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.wand_of_the_war_mage_plus_3_description,
            value = 19200,
            powerLevel = 569,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.WAND_OF_WEB,
            nameResId = R.string.wand_of_web,
            type = ItemType.WAND,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.wand_of_web_description,
            value = 8000,
            powerLevel = 370,
            requiresAttunement = true,
            lootExclusive = true
        ),

        // RODS
        LocalItem(
            id = ItemIds.ROD_OF_THE_PACT_KEEPER_PLUS_1,
            nameResId = R.string.rod_of_the_pact_keeper_plus_1,
            type = ItemType.ROD,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.rod_of_the_pact_keeper_plus_1_description,
            value = 12000,
            powerLevel = 363,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.ROD_OF_THE_PACT_KEEPER_PLUS_2,
            nameResId = R.string.rod_of_the_pact_keeper_plus_2,
            type = ItemType.ROD,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.rod_of_the_pact_keeper_plus_2_description,
            value = 16000,
            powerLevel = 463,
            requiresAttunement = true,
            lootExclusive = true
        ),
        LocalItem(
            id = ItemIds.ROD_OF_THE_PACT_KEEPER_PLUS_3,
            nameResId = R.string.rod_of_the_pact_keeper_plus_3,
            type = ItemType.ROD,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.rod_of_the_pact_keeper_plus_3_description,
            value = 28000,
            powerLevel = 563,
            requiresAttunement = true,
            lootExclusive = true
        ),

        // STAFFS
        LocalItem(
            id = ItemIds.STAFF_OF_THE_ADDER,
            nameResId = R.string.staff_of_the_adder,
            type = ItemType.STAFF,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.staff_of_the_adder_description,
            value = 1800,
            powerLevel = 365,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.STAFF_OF_THE_PYTHON,
            nameResId = R.string.staff_of_the_python,
            type = ItemType.STAFF,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.staff_of_the_python_description,
            value = 2000,
            powerLevel = 366,
            requiresAttunement = true
        ),
        LocalItem(
            id = ItemIds.RAIN_DANCER,
            nameResId = R.string.rain_dancer,
            type = ItemType.STAFF,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.rain_dancer_description,
            descriptionExtraResId = R.string.rain_dancer_description_extra,
            value = 1500,
            powerLevel = 165,
            vendorExclusive = true,
            origin = ItemOrigin.BG3
        ),
        LocalItem(
            id = ItemIds.STAFF_OF_CRONES,
            nameResId = R.string.staff_of_crones,
            type = ItemType.STAFF,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.staff_of_crones_description,
            descriptionExtraResId = R.string.staff_of_crones_description_extra,
            value = 1000,
            powerLevel = 180,
            lootExclusive = true,
            origin = ItemOrigin.BG3
        ),
    )
}