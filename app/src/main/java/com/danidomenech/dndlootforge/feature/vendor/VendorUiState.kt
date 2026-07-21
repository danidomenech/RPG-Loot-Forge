package com.danidomenech.dndlootforge.feature.vendor

import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.feature.vendor.VendorViewModel.Companion.DEFAULT_PLAYER_LEVEL

data class VendorUiState(
    val items: List<Item> = emptyList(),
    val playerLevel: Int = DEFAULT_PLAYER_LEVEL
)