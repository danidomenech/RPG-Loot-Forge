package com.danidomenech.dndlootforge.domain.usecase

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.sortOrder
import javax.inject.Inject

class GetNarrativeLootItemsUseCase @Inject constructor(
    private val getAllItemsUseCase: GetAllItemsUseCase
) {

    operator fun invoke(): List<Item> {
        return getAllItemsUseCase()
            .filter { it.narrativeLootExclusive }
            .sortedWith(
                compareBy<Item> { it.powerLevel }
                    .thenBy { it.rarity.sortOrder }
            )
    }
}