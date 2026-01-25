package com.danidomenech.dndlootforge.domain.usecase

import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.repository.ItemRepository
import jakarta.inject.Inject

class GetAllItemsUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    operator fun invoke(): List<Item> = repository.getAllItems()
}