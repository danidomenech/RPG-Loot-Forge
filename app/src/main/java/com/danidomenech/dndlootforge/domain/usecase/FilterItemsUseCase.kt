package com.danidomenech.dndlootforge.domain.usecase

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootListFilters
import javax.inject.Inject

class FilterItemsUseCase @Inject constructor() {

    operator fun invoke(
        items: List<Item>,
        filters: LootListFilters
    ): List<Item> {
        return items.filter { item ->
            filters.rarities.isEmpty() ||
                    item.rarity in filters.rarities
        }
    }
}