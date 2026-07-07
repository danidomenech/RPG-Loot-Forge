package com.danidomenech.dndlootforge.data.local.catalog

import com.danidomenech.dndlootforge.data.local.model.LocalItem

internal object LocalItemCatalog {

    val items: List<LocalItem> =
        AccessoryItemCatalog.items +
                ArmorItemCatalog.items +
                ConsumableItemCatalog.items +
                WeaponItemCatalog.items +
                MiscItemCatalog.items

    init {
        checkNoDuplicatedIds()
    }

    private fun checkNoDuplicatedIds() {
        val duplicatedIds = items
            .groupBy { it.id }
            .filterValues { it.size > 1 }
            .keys

        check(duplicatedIds.isEmpty()) {
            "Duplicated item ids found: $duplicatedIds"
        }
    }
}