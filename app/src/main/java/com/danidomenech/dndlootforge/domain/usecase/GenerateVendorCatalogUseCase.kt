package com.danidomenech.dndlootforge.domain.usecase

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.rules.ItemSortingRules
import com.danidomenech.dndlootforge.domain.rules.LootTableRules
import javax.inject.Inject
import kotlin.random.Random

class GenerateVendorCatalogUseCase @Inject constructor() {

    operator fun invoke(
        vendorItems: List<Item>,
        playerLevel: Int,
        stockPercentage: Int,
        random: Random = Random.Default
    ): List<Item> {
        val maxPowerLevel = getMaxPowerLevelForPlayerLevel(playerLevel)

        val generatedItems = when (stockPercentage) {
            STOCK_EMPTY_PERCENT -> emptyList()
            STOCK_FULL_PERCENT -> vendorItems
            else -> generateRandomCatalogItems(
                vendorItems = vendorItems,
                maxPowerLevel = maxPowerLevel,
                stockPercentage = stockPercentage,
                random = random
            )
        }

        return generatedItems.sortedWith(ItemSortingRules.vendorCatalogComparator)
    }

    private fun generateRandomCatalogItems(
        vendorItems: List<Item>,
        maxPowerLevel: Int,
        stockPercentage: Int,
        random: Random
    ): List<Item> {
        val multiplier = stockPercentage / BASE_STOCK_PERCENTAGE

        return vendorItems.filter { item ->
            val powerLevel = item.powerLevel.coerceAtMost(maxPowerLevel)
            val baseChance = (maxPowerLevel + 1) - powerLevel

            val rawChance = if (baseChance <= MAX_PERCENTAGE) {
                baseChance.coerceIn(0, MAX_PERCENTAGE)
            } else {
                val firstDigit = baseChance.toString().first().digitToInt()
                val extraMultiplier = firstDigit + 1
                val remainder = baseChance % MAX_PERCENTAGE

                (remainder * extraMultiplier).coerceIn(0, MAX_PERCENTAGE)
            }

            val adjustedChance = (rawChance * multiplier)
                .toInt()
                .coerceIn(0, MAX_PERCENTAGE)

            random.nextInt(0, MAX_PERCENTAGE) < adjustedChance
        }
    }

    private fun getMaxPowerLevelForPlayerLevel(playerLevel: Int): Int {
        val allowedTables = LootTableRules.getTablesForPlayerLevel(playerLevel)

        return allowedTables
            .mapNotNull { table -> LootTableRules.lootTableRanges[table]?.last }
            .maxOrNull()
            ?: DEFAULT_MAX_POWER_LEVEL
    }

    private companion object {
        const val STOCK_EMPTY_PERCENT = 0
        const val STOCK_FULL_PERCENT = 100
        const val BASE_STOCK_PERCENTAGE = 50f
        const val MAX_PERCENTAGE = 100
        const val DEFAULT_MAX_POWER_LEVEL = 0
    }
}