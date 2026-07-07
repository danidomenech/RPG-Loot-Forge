package com.danidomenech.dndlootforge.core.design.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.domain.model.ItemType


@Composable
fun ItemType.text(): String {
    return stringResource(stringResId)
}

val ItemType.stringResId: Int
    get() = when (this) {
        ItemType.WEAPON -> R.string.item_type_weapon
        ItemType.JAVELIN -> R.string.item_type_javelin
        ItemType.DAGGER -> R.string.item_type_dagger
        ItemType.SHORT_SWORD -> R.string.item_type_short_sword
        ItemType.LONG_SWORD -> R.string.item_type_long_sword
        ItemType.GREATSWORD -> R.string.item_type_greatsword
        ItemType.HAND_AXE -> R.string.item_type_hand_axe
        ItemType.BATTLE_AXE -> R.string.item_type_battle_axe
        ItemType.GREATAXE -> R.string.item_type_greataxe
        ItemType.WARHAMMER -> R.string.item_type_warhammer
        ItemType.MAUL -> R.string.item_type_maul
        ItemType.SHORT_BOW -> R.string.item_type_short_bow
        ItemType.LONG_BOW -> R.string.item_type_long_bow
        ItemType.HAND_CROSSBOW -> R.string.item_type_hand_crossbow
        ItemType.LIGHT_CROSSBOW -> R.string.item_type_light_crossbow
        ItemType.HEAVY_CROSSBOW -> R.string.item_type_heavy_crossbow
        ItemType.TRIDENT -> R.string.item_type_trident
        ItemType.STAFF -> R.string.item_type_staff
        ItemType.ROD -> R.string.item_type_rod
        ItemType.ARMOR -> R.string.item_type_armor
        ItemType.CLOTHING -> R.string.item_type_clothing
        ItemType.LIGHT_ARMOR -> R.string.item_type_light_armor
        ItemType.MEDIUM_ARMOR -> R.string.item_type_medium_armor
        ItemType.HEAVY_ARMOR -> R.string.item_type_heavy_armor
        ItemType.SHIELD -> R.string.item_type_shield
        ItemType.ACCESSORY -> R.string.item_type_accessory
        ItemType.HELMET -> R.string.item_type_helmet
        ItemType.GLOVES -> R.string.item_type_gloves
        ItemType.BOOTS -> R.string.item_type_boots
        ItemType.NECKLACE -> R.string.item_type_necklace
        ItemType.CLOAK -> R.string.item_type_cloak
        ItemType.RING -> R.string.item_type_ring
        ItemType.WAND -> R.string.item_type_wand
        ItemType.POTION -> R.string.item_type_potion
        ItemType.CONSUMABLE -> R.string.item_type_consumable
        ItemType.AMMUNITION -> R.string.item_type_ammunition
        ItemType.SCROLL -> R.string.item_type_scroll
        ItemType.MAGICAL_TOOL -> R.string.item_type_magical_tool
        ItemType.MISC -> R.string.item_type_misc
    }