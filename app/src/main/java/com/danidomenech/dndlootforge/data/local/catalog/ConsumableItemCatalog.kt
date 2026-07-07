package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import com.danidomenech.dndlootforge.domain.model.ItemIds
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.ItemType
import com.danidomenech.dndlootforge.domain.model.LootTable

internal object ConsumableItemCatalog {

    val items = listOf(
        // POTIONS
        LocalItem(
            id = ItemIds.HEALING_POTION,
            nameResId = R.string.healing_potion,
            type = ItemType.POTION,
            rarity = ItemRarity.COMMON,
            descriptionResId = R.string.healing_potion_description,
            descriptionExtraResId = R.string.healing_potion_description_extra,
            value = 50,
            powerLevel = 1
        ),
        LocalItem(
            id = ItemIds.GREATER_HEALING_POTION,
            nameResId = R.string.greater_healing_potion,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.greater_healing_potion_description,
            descriptionExtraResId = R.string.healing_potion_description_extra,
            value = 150,
            powerLevel = 85,
            overrideTables = listOf(LootTable.B)
        ),
        LocalItem(
            id = ItemIds.SUPERIOR_HEALING_POTION,
            nameResId = R.string.superior_healing_potion,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.superior_healing_potion_description,
            descriptionExtraResId = R.string.healing_potion_description_extra,
            value = 450,
            powerLevel = 201
        ),
        LocalItem(
            id = ItemIds.SUPREME_HEALING_POTION,
            nameResId = R.string.supreme_healing_potion,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.supreme_healing_potion_description,
            descriptionExtraResId = R.string.healing_potion_description_extra,
            value = 1350,
            powerLevel = 301,
            overrideTables = listOf(LootTable.E)
        ),
        LocalItem(
            id = ItemIds.POTION_OF_FIRE_BREATH,
            nameResId = R.string.potion_of_fire_breath,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_fire_breath_description,
            descriptionExtraResId = R.string.potion_of_fire_breath_description_extra,
            value = 150,
            powerLevel = 110
        ),
        LocalItem(
            id = ItemIds.POTION_OF_RESISTANCE,
            nameResId = R.string.potion_of_resistance,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_resistance_description,
            value = 300,
            powerLevel = 110
        ),
        LocalItem(
            id = ItemIds.POTION_OF_ANIMAL_FRIENDSHIP,
            nameResId = R.string.potion_of_animal_friendship,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_animal_friendship_description,
            descriptionExtraResId = R.string.potion_of_animal_friendship_description_extra,
            value = 200,
            powerLevel = 115,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.POTION_OF_HILL_GIANT_STRENGTH,
            nameResId = R.string.potion_of_hill_giant_strength,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_hill_giant_strength_description,
            descriptionExtraResId = R.string.potion_of_giant_strength_description_extra,
            value = 4000,
            powerLevel = 180
        ),
        LocalItem(
            id = ItemIds.POTION_OF_FROST_STONE_GIANT_STRENGTH,
            nameResId = R.string.potion_of_frost_stone_giant_strength,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_frost_stone_giant_strength_description,
            descriptionExtraResId = R.string.potion_of_giant_strength_description_extra,
            value = 8000,
            powerLevel = 280
        ),
        LocalItem(
            id = ItemIds.POTION_OF_FIRE_GIANT_STRENGTH,
            nameResId = R.string.potion_of_fire_giant_strength,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_fire_giant_strength_description,
            descriptionExtraResId = R.string.potion_of_giant_strength_description_extra,
            value = 12000,
            powerLevel = 380
        ),
        LocalItem(
            id = ItemIds.POTION_OF_CLOUD_GIANT_STRENGTH,
            nameResId = R.string.potion_of_cloud_giant_strength,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.potion_of_cloud_giant_strength_description,
            descriptionExtraResId = R.string.potion_of_giant_strength_description_extra,
            value = 18000,
            powerLevel = 480
        ),
        LocalItem(
            id = ItemIds.POTION_OF_STORM_GIANT_STRENGTH,
            nameResId = R.string.potion_of_storm_giant_strength,
            type = ItemType.POTION,
            rarity = ItemRarity.LEGENDARY,
            descriptionResId = R.string.potion_of_storm_giant_strength_description,
            descriptionExtraResId = R.string.potion_of_giant_strength_description_extra,
            value = 24000,
            powerLevel = 580
        ),
        LocalItem(
            id = ItemIds.POTION_OF_GROWTH,
            nameResId = R.string.potion_of_growth,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_growth_description,
            descriptionExtraResId = R.string.potion_of_growth_description_extra,
            value = 270,
            powerLevel = 160,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.POTION_OF_WATER_BREATHING,
            nameResId = R.string.potion_of_water_breathing,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_water_breathing_description,
            descriptionExtraResId = R.string.potion_of_water_breathing_description_extra,
            value = 180,
            powerLevel = 160,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.PHILTER_OF_LOVE,
            nameResId = R.string.philter_of_love,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.philter_of_love_description,
            descriptionExtraResId = R.string.philter_of_love_description_extra,
            value = 5000,
            powerLevel = 395,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.POTION_OF_POISON,
            nameResId = R.string.potion_of_poison,
            type = ItemType.POTION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.potion_of_poison_description,
            descriptionExtraResId = R.string.potion_of_poison_description_extra,
            value = 250,
            powerLevel = 191,
            vendorExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.ANTIDOTE,
            nameResId = R.string.antidote,
            type = ItemType.POTION,
            rarity = ItemRarity.COMMON,
            descriptionResId = R.string.antidote_description,
            descriptionExtraResId = R.string.antidote_description_extra,
            value = 75,
            powerLevel = 181,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.POTION_OF_DIMINUTION,
            nameResId = R.string.potion_of_diminution,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_diminution_description,
            descriptionExtraResId = R.string.potion_of_diminution_description_extra,
            value = 270,
            powerLevel = 220,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.POTION_OF_GASEOUS_FORM,
            nameResId = R.string.potion_of_gaseous_form,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_gaseous_form_description,
            descriptionExtraResId = R.string.potion_of_gaseous_form_description_extra,
            value = 300,
            powerLevel = 220,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.POTION_OF_HEROISM,
            nameResId = R.string.potion_of_heroism,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_heroism_description,
            descriptionExtraResId = R.string.potion_of_heroism_description_extra,
            value = 360,
            powerLevel = 230
        ),
        LocalItem(
            id = ItemIds.POTION_OF_INVULNERABILITY,
            nameResId = R.string.potion_of_invulnerability,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_invulnerability_description,
            descriptionExtraResId = R.string.potion_of_invulnerability_description_extra,
            value = 3840,
            powerLevel = 230
        ),
        LocalItem(
            id = ItemIds.POTION_OF_MIND_READING,
            nameResId = R.string.potion_of_mind_reading,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.potion_of_mind_reading_description,
            descriptionExtraResId = R.string.potion_of_mind_reading_description_extra,
            value = 180,
            powerLevel = 230,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ELIXIR_OF_HEALTH,
            nameResId = R.string.elixir_of_health,
            type = ItemType.POTION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.elixir_of_health_description,
            descriptionExtraResId = R.string.elixir_of_health_description_extra,
            value = 150,
            powerLevel = 230,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.POTION_OF_INVISIBILITY,
            nameResId = R.string.potion_of_invisibility,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.potion_of_invisibility_description,
            descriptionExtraResId = R.string.potion_of_invisibility_description_extra,
            value = 3000,
            powerLevel = 350
        ),
        LocalItem(
            id = ItemIds.POTION_OF_SPEED,
            nameResId = R.string.potion_of_speed,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.potion_of_speed_description,
            descriptionExtraResId = R.string.potion_of_speed_description_extra,
            value = 400,
            powerLevel = 350
        ),
        LocalItem(
            id = ItemIds.POTION_OF_FLYING,
            nameResId = R.string.potion_of_flying,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.potion_of_flying_description,
            descriptionExtraResId = R.string.potion_of_flying_description_extra,
            value = 500,
            powerLevel = 375
        ),
        LocalItem(
            id = ItemIds.POTION_OF_VITALITY,
            nameResId = R.string.potion_of_vitality,
            type = ItemType.POTION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.potion_of_vitality_description,
            descriptionExtraResId = R.string.potion_of_vitality_description_extra,
            value = 960,
            powerLevel = 375,
            vendorExclusive = true
        ),

        // SCROLLS
        LocalItem(
            id = ItemIds.CANTRIP_SCROLL,
            nameResId = R.string.cantrip_scroll,
            type = ItemType.SCROLL,
            rarity = ItemRarity.COMMON,
            descriptionResId = R.string.cantrip_scroll_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 10,
            powerLevel = 50,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_1,
            nameResId = R.string.spell_scroll_lvl_1,
            type = ItemType.SCROLL,
            rarity = ItemRarity.COMMON,
            descriptionResId = R.string.spell_scroll_lvl_1_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 60,
            powerLevel = 51,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_2,
            nameResId = R.string.spell_scroll_lvl_2,
            type = ItemType.SCROLL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.spell_scroll_lvl_2_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 120,
            powerLevel = 170,
            origin = ItemOrigin.BOOK_EDITED,
            lootExclusive = true,
            overrideTables = listOf(LootTable.A)
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_3,
            nameResId = R.string.spell_scroll_lvl_3,
            type = ItemType.SCROLL,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.spell_scroll_lvl_3_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 200,
            powerLevel = 175,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_4,
            nameResId = R.string.spell_scroll_lvl_4,
            type = ItemType.SCROLL,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.spell_scroll_lvl_4_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 320,
            powerLevel = 250,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_5,
            nameResId = R.string.spell_scroll_lvl_5,
            type = ItemType.SCROLL,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.spell_scroll_lvl_5_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 640,
            powerLevel = 350,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_6,
            nameResId = R.string.spell_scroll_lvl_6,
            type = ItemType.SCROLL,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.spell_scroll_lvl_6_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 1280,
            powerLevel = 450,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_7,
            nameResId = R.string.spell_scroll_lvl_7,
            type = ItemType.SCROLL,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.spell_scroll_lvl_7_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 2560,
            powerLevel = 550,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_8,
            nameResId = R.string.spell_scroll_lvl_8,
            type = ItemType.SCROLL,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.spell_scroll_lvl_8_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 5120,
            powerLevel = 650,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),
        LocalItem(
            id = ItemIds.SPELL_SCROLL_LVL_9,
            nameResId = R.string.spell_scroll_lvl_9,
            type = ItemType.SCROLL,
            rarity = ItemRarity.LEGENDARY,
            descriptionResId = R.string.spell_scroll_lvl_9_description,
            descriptionExtraResId = R.string.spell_scroll_description_extra,
            value = 10240,
            powerLevel = 750,
            lootExclusive = true,
            origin = ItemOrigin.BOOK_EDITED
        ),

        // AMMUNITION
        LocalItem(
            id = ItemIds.AMMUNITION_1,
            nameResId = R.string.ammunition_1,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.ammunition_description,
            value = 50,
            powerLevel = 120,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.AMMUNITION_2,
            nameResId = R.string.ammunition_2,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.ammunition_description,
            value = 200,
            powerLevel = 220,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.AMMUNITION_3,
            nameResId = R.string.ammunition_3,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.ammunition_description,
            value = 800,
            powerLevel = 320,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ARROW_OF_ACID,
            nameResId = R.string.arrow_of_acid,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.arrow_of_acid_description,
            descriptionExtraResId = R.string.arrow_of_acid_description_extra,
            value = 100,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ARROW_OF_FIRE,
            nameResId = R.string.arrow_of_fire,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.arrow_of_fire_description,
            descriptionExtraResId = R.string.arrow_of_fire_description_extra,
            value = 100,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ARROW_OF_ICE,
            nameResId = R.string.arrow_of_ice,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.arrow_of_ice_description,
            descriptionExtraResId = R.string.arrow_of_ice_description_extra,
            value = 100,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ARROW_OF_LIGHTNING,
            nameResId = R.string.arrow_of_lightning,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.arrow_of_lightning_description,
            descriptionExtraResId = R.string.arrow_of_lightning_description_extra,
            value = 100,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.STUNNING_AMMUNITION,
            nameResId = R.string.stunning_ammunition,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.COMMON,
            descriptionResId = R.string.stunning_ammunition_description,
            descriptionExtraResId = R.string.stunning_ammunition_description_extra,
            value = 5,
            powerLevel = 120,
            origin = ItemOrigin.HOMEBREW,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ARROW_OF_SLAYING,
            nameResId = R.string.arrow_of_slaying,
            type = ItemType.AMMUNITION,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.arrow_of_slaying_description,
            descriptionExtraResId = R.string.arrow_of_slaying_description_extra,
            value = 1200,
            powerLevel = 480,
            vendorExclusive = true
        ),

        // OTHER CONSUMABLES
        LocalItem(
            id = ItemIds.ALCHEMIST_FIRE,
            nameResId = R.string.alchemist_fire,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.alchemist_fire_description,
            descriptionExtraResId = R.string.alchemist_fire_description_extra,
            value = 120,
            powerLevel = 175,
            origin = ItemOrigin.BOOK_EDITED,
            overrideTables = listOf(LootTable.A)
        ),
        LocalItem(
            id = ItemIds.OIL_OF_SLIPPERINESS,
            nameResId = R.string.oil_of_slipperiness,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.oil_of_slipperiness_description,
            descriptionExtraResId = R.string.oil_of_slipperiness_description_extra,
            value = 480,
            powerLevel = 150,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.DUST_OF_DISAPPEARANCE,
            nameResId = R.string.dust_of_disappearance,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.dust_of_disappearance_description,
            descriptionExtraResId = R.string.dust_of_disappearance_description_extra,
            value = 300,
            powerLevel = 161,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.DUST_OF_SNEEZING_AND_CHOKING,
            nameResId = R.string.dust_of_sneezing_and_choking,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.dust_of_sneezing_and_choking_description,
            descriptionExtraResId = R.string.dust_of_sneezing_and_choking_description_extra,
            value = 480,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ELEMENTAL_GEM_RED_CORUNDUM,
            nameResId = R.string.elemental_gem_red_corundum,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.elemental_gem_red_corundum_description,
            descriptionExtraResId = R.string.elemental_gem_red_corundum_description_extra,
            value = 960,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ELEMENTAL_GEM_YELLOW_DIAMOND,
            nameResId = R.string.elemental_gem_yellow_diamond,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.elemental_gem_yellow_diamond_description,
            descriptionExtraResId = R.string.elemental_gem_yellow_diamond_description_extra,
            value = 960,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ELEMENTAL_GEM_BLUE_SAPPHIRE,
            nameResId = R.string.elemental_gem_blue_sapphire,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.elemental_gem_blue_sapphire_description,
            descriptionExtraResId = R.string.elemental_gem_blue_sapphire_description_extra,
            value = 960,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.ELEMENTAL_GEM_EMERALD,
            nameResId = R.string.elemental_gem_emerald,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.elemental_gem_emerald_description,
            descriptionExtraResId = R.string.elemental_gem_emerald_description_extra,
            value = 960,
            powerLevel = 180,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.BEAD_OF_FORCE,
            nameResId = R.string.bead_of_force,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.RARE,
            descriptionResId = R.string.bead_of_force_description,
            descriptionExtraResId = R.string.bead_of_force_description_extra,
            value = 620,
            powerLevel = 260,
            vendorExclusive = true
        ),
        LocalItem(
            id = ItemIds.OIL_OF_SHARPNESS,
            nameResId = R.string.oil_of_sharpness,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.VERY_RARE,
            descriptionResId = R.string.oil_of_sharpness_description,
            descriptionExtraResId = R.string.oil_of_sharpness_description_extra,
            value = 3200,
            powerLevel = 370
        ),
        LocalItem(
            id = ItemIds.OIL_OF_ACCURACY,
            nameResId = R.string.oil_of_accuracy,
            type = ItemType.CONSUMABLE,
            rarity = ItemRarity.UNCOMMON,
            descriptionResId = R.string.oil_of_accuracy_description,
            descriptionExtraResId = R.string.oil_of_accuracy_description_extra,
            value = 1200,
            powerLevel = 180,
            origin = ItemOrigin.BG3_EDITED
        ),
    )
}