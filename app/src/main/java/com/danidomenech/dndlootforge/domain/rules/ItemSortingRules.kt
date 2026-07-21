package com.danidomenech.dndlootforge.domain.rules

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.ItemType
import com.danidomenech.dndlootforge.domain.model.sortOrder

object ItemSortingRules {

    val vendorCatalogTypeOrder = listOf(
        ItemType.POTION,
        ItemType.CONSUMABLE,
        ItemType.AMMUNITION,
        ItemType.SCROLL,
        ItemType.MAGICAL_TOOL,
        ItemType.CLOTHING,
        ItemType.LIGHT_ARMOR,
        ItemType.MEDIUM_ARMOR,
        ItemType.HEAVY_ARMOR,
        ItemType.ARMOR,
        ItemType.HELMET,
        ItemType.GLOVES,
        ItemType.BOOTS,
        ItemType.CLOAK,
        ItemType.ACCESSORY,
        ItemType.NECKLACE,
        ItemType.RING,
        ItemType.SHIELD,
        ItemType.WEAPON,
        ItemType.DAGGER,
        ItemType.SHORT_SWORD,
        ItemType.LONG_SWORD,
        ItemType.GREATSWORD,
        ItemType.HAND_AXE,
        ItemType.BATTLE_AXE,
        ItemType.GREATAXE,
        ItemType.WARHAMMER,
        ItemType.MAUL,
        ItemType.SHORT_BOW,
        ItemType.LONG_BOW,
        ItemType.HAND_CROSSBOW,
        ItemType.LIGHT_CROSSBOW,
        ItemType.HEAVY_CROSSBOW,
        ItemType.TRIDENT,
        ItemType.JAVELIN,
        ItemType.STAFF,
        ItemType.ROD,
        ItemType.WAND
    )

    val vendorCatalogComparator = compareBy<Item>(
        { item -> vendorCatalogTypeOrder.indexOf(item.type).takeIf { it >= 0 } ?: Int.MAX_VALUE },
        { item -> item.rarity.sortOrder },
        { item -> item.powerLevel }
    )
}