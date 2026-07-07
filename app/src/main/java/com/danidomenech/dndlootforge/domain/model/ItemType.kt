package com.danidomenech.dndlootforge.domain.model

enum class ItemType(
    val category: ItemCategory
) {
    WEAPON(ItemCategory.WEAPON),
    JAVELIN(ItemCategory.WEAPON),
    DAGGER(ItemCategory.WEAPON),
    SHORT_SWORD(ItemCategory.WEAPON),
    LONG_SWORD(ItemCategory.WEAPON),
    HAND_AXE(ItemCategory.WEAPON),
    BATTLE_AXE(ItemCategory.WEAPON),
    GREATSWORD(ItemCategory.WEAPON),
    GREATAXE(ItemCategory.WEAPON),
    WARHAMMER(ItemCategory.WEAPON),
    MAUL(ItemCategory.WEAPON),
    SHORT_BOW(ItemCategory.WEAPON),
    LONG_BOW(ItemCategory.WEAPON),
    HAND_CROSSBOW(ItemCategory.WEAPON),
    LIGHT_CROSSBOW(ItemCategory.WEAPON),
    HEAVY_CROSSBOW(ItemCategory.WEAPON),
    TRIDENT(ItemCategory.WEAPON),

    CLOTHING(ItemCategory.ARMOR),
    ARMOR(ItemCategory.ARMOR),
    LIGHT_ARMOR(ItemCategory.ARMOR),
    MEDIUM_ARMOR(ItemCategory.ARMOR),
    HEAVY_ARMOR(ItemCategory.ARMOR),
    HELMET(ItemCategory.ARMOR),
    GLOVES(ItemCategory.ARMOR),
    BOOTS(ItemCategory.ARMOR),
    SHIELD(ItemCategory.ARMOR),

    ACCESSORY(ItemCategory.ACCESSORY),
    NECKLACE(ItemCategory.ACCESSORY),
    CLOAK(ItemCategory.ACCESSORY),
    RING(ItemCategory.ACCESSORY),

    STAFF(ItemCategory.MAGICAL_FOCUS),
    ROD(ItemCategory.MAGICAL_FOCUS),
    WAND(ItemCategory.MAGICAL_FOCUS),

    POTION(ItemCategory.CONSUMABLE),
    CONSUMABLE(ItemCategory.CONSUMABLE),

    AMMUNITION(ItemCategory.AMMUNITION),
    SCROLL(ItemCategory.SCROLL),
    MAGICAL_TOOL(ItemCategory.MAGICAL_TOOL),

    MISC(ItemCategory.MISC)
}

//enum class ItemSubType { //TODO expand this
//    // Weapons
//    LONGSWORD, GREATSWORD, SHORTSWORD, LONGBOW, DAGGER, CROSSBOW, STAFF,
//    // Armor
//    LIGHT_ARMOR, MEDIUM_ARMOR, HEAVY_ARMOR, HELMET, SHIELD, GAUNTLETS, BOOTS,
//    // Accessories
//    RING, AMULET, BELT, CLOAK,
//    // Scrolls & misc
//    FIREBALL_SCROLL, IDENTIFY_SCROLL, KEY_ITEM, GEM, TOOL, OTHER
//}