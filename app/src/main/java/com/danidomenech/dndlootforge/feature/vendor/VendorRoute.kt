package com.danidomenech.dndlootforge.feature.vendor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danidomenech.dndlootforge.domain.model.Item

@Composable
fun VendorRoute(
    viewModel: VendorViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit,
    onGenerateCatalogClick: (playerLevel: Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    VendorScreen(
        uiState = uiState,
        onAction = { action ->
            when (action) {
                is VendorAction.PlayerLevelChange -> {
                    viewModel.onAction(action)
                }

                is VendorAction.ItemClick -> {
                    onItemClick(action.item, null)
                }

                is VendorAction.GenerateCatalogClick -> {
                    onGenerateCatalogClick(action.playerLevel)
                }
            }
        }
    )
}