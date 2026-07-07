package com.danidomenech.dndlootforge.domain.usecase

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.repository.ItemRepository
import javax.inject.Inject

class GetAllItemsUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    operator fun invoke(): List<Item> = repository.getAllItems()
}