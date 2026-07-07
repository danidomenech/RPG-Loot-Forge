package com.danidomenech.dndlootforge.data.repository

import com.danidomenech.dndlootforge.data.local.source.ItemLocalDataSource
import com.danidomenech.dndlootforge.data.mapper.toDomain
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val localDataSource: ItemLocalDataSource
) : ItemRepository {

    override fun getAllItems(): List<Item> {
        return localDataSource.getItems()
            .map { it.toDomain() }
    }
}