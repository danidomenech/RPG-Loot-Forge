package com.danidomenech.dndlootforge.feature.vendor

import com.danidomenech.dndlootforge.domain.model.Item

sealed interface VendorAction {
    data class PlayerLevelChange(val playerLevel: Int) : VendorAction
    data class ItemClick(val item: Item) : VendorAction
    data class GenerateCatalogClick(val playerLevel: Int) : VendorAction
}