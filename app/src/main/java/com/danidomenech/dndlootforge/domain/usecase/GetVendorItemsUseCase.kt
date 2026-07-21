package com.danidomenech.dndlootforge.domain.usecase

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.rules.ItemSortingRules
import com.danidomenech.dndlootforge.domain.rules.LootTableRules
import javax.inject.Inject

class GetVendorItemsUseCase @Inject constructor(
    private val getAllItemsUseCase: GetAllItemsUseCase
) {

    operator fun invoke(
        playerLevel: Int
    ): List<Item> {
        val allowedTables = LootTableRules.getTablesForPlayerLevel(playerLevel)
        val allowedRanges = allowedTables.mapNotNull { table ->
            LootTableRules.lootTableRanges[table]
        }

        return getAllItemsUseCase()
            .filter { item ->
                item.vendorExclusive ||
                        (!item.lootExclusive && !item.narrativeLootExclusive)
            }
            .filter { item ->
                allowedRanges.any { range ->
                    item.powerLevel in range
                }
            }
            .sortedWith(ItemSortingRules.vendorCatalogComparator)
    }
}