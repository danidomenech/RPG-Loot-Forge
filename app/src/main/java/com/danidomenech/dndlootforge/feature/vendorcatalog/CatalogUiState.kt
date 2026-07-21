package com.danidomenech.dndlootforge.feature.vendorcatalog

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogDefaults.DEFAULT_PRICE_MODIFIER_PERCENTAGE
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogDefaults.DEFAULT_STOCK_PERCENTAGE

data class CatalogUiState(
    val items: List<Item> = emptyList(),
    val catalogGenerated: Boolean = false,
    val stockPercentage: Int = DEFAULT_STOCK_PERCENTAGE,
    val priceModifierPercentage: Int = DEFAULT_PRICE_MODIFIER_PERCENTAGE
)