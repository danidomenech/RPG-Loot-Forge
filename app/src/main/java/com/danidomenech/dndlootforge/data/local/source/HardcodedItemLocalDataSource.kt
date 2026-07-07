package com.danidomenech.dndlootforge.data.local.source

import com.danidomenech.dndlootforge.data.local.catalog.LocalItemCatalog
import com.danidomenech.dndlootforge.data.local.model.LocalItem
import javax.inject.Inject

class HardcodedItemLocalDataSource @Inject constructor() : ItemLocalDataSource {

    override fun getItems(): List<LocalItem> {
        return LocalItemCatalog.items
    }
}