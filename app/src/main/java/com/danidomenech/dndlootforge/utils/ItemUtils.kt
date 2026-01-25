package com.danidomenech.dndlootforge.utils

import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.model.ItemRarity
import com.danidomenech.dndlootforge.data.model.ItemType
import com.danidomenech.dndlootforge.data.model.LootTable

object ItemUtils {

    val lootTableRanges: Map<LootTable, IntRange> = mapOf(
        LootTable.A to 1..99,
        LootTable.B to 100..199,
        LootTable.C to 200..299,
        LootTable.D to 300..399,
        LootTable.E to 400..499,
        LootTable.F to 500..599,
        LootTable.G to 600..699,
        LootTable.H to 700..799,
        LootTable.I to 800..899
    )

    fun getTableForPowerLevel(powerLevel: Int): LootTable? {
        return lootTableRanges.entries.firstOrNull { (_, range) ->
            powerLevel in range
        }?.key
    }

    fun getRangeForTable(table: LootTable): IntRange {
        return lootTableRanges[table]
            ?: throw IllegalArgumentException("Unknown table: $table")
    }

    val playerLevelTables: Map<LootTable, IntRange> = mapOf(
        LootTable.A to 1..2,
        LootTable.B to 3..4,
        LootTable.C to 5..7,
        LootTable.D to 8..10,
        LootTable.E to 11..13,
        LootTable.F to 14..17,
        LootTable.G to 18..18,
        LootTable.H to 19..19,
        LootTable.I to 20..20
    )

    fun getTablesForPlayerLevel(playerLevel: Int): List<LootTable> {
        return playerLevelTables
            .filter { (_, levelRange) -> playerLevel >= levelRange.first }
            .map { (table, _) -> table }
    }

    fun Item.getRequiredPlayerLevel(): Int? {
        val lootTable = ItemUtils.getTableForPowerLevel(this.powerLevel)
        return lootTable?.let { ItemUtils.playerLevelTables[it]?.first }
    }

    fun ItemType.isGear(): Boolean {
        return this in listOf(
            ItemType.CLOTHING,
            ItemType.ARMOR,
            ItemType.LIGHT_ARMOR,
            ItemType.MEDIUM_ARMOR,
            ItemType.HEAVY_ARMOR,
            ItemType.SHIELD,
            ItemType.ACCESSORY,
            ItemType.HELMET,
            ItemType.GLOVES,
            ItemType.BOOTS,
            ItemType.NECKLACE,
            ItemType.CLOAK,
            ItemType.RING,
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
    }

    val rarityOrder = listOf(
        ItemRarity.COMMON,
        ItemRarity.UNCOMMON,
        ItemRarity.RARE,
        ItemRarity.VERY_RARE,
        ItemRarity.LEGENDARY
    )

}