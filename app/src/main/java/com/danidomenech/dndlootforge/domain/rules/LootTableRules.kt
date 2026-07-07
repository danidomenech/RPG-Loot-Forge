package com.danidomenech.dndlootforge.domain.rules

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootTable

object LootTableRules {

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

    private fun getTableForPowerLevel(powerLevel: Int): LootTable? {
        return lootTableRanges.entries.firstOrNull { (_, range) ->
            powerLevel in range
        }?.key
    }

    fun getPowerLevelRangeForTable(table: LootTable): IntRange {
        return lootTableRanges[table]
            ?: throw IllegalArgumentException("Unknown table: $table")
    }

    fun getTablesForPlayerLevel(playerLevel: Int): List<LootTable> {
        return playerLevelTables
            .filter { (_, levelRange) -> playerLevel >= levelRange.first }
            .map { (table, _) -> table }
    }

    fun Item.getRequiredPlayerLevel(): Int? {
        val lootTable = getTableForPowerLevel(this.powerLevel)
        return lootTable?.let { playerLevelTables[it]?.first }
    }

}