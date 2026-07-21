package com.danidomenech.dndlootforge.feature.vendorcatalog

import com.danidomenech.dndlootforge.domain.model.Item

sealed interface CatalogAction {
    data class StockPercentageChange(val percentage: Int) : CatalogAction
    data class PriceModifierChange(val percentage: Int) : CatalogAction
    data class ItemClick(val item: Item) : CatalogAction
    data object GenerateCatalogClick : CatalogAction
    data object RerollCatalogClick : CatalogAction
    data object EditModifiersClick : CatalogAction
}