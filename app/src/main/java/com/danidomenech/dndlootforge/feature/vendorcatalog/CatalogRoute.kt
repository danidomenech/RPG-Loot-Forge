package com.danidomenech.dndlootforge.feature.vendorcatalog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danidomenech.dndlootforge.domain.model.Item

@Composable
fun CatalogRoute(
    playerLevel: Int,
    viewModel: CatalogViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(playerLevel) {
        viewModel.setPlayerLevel(playerLevel)
    }

    CatalogScreen(
        uiState = uiState,
        onAction = { action ->
            when (action) {
                is CatalogAction.ItemClick -> {
                    onItemClick(
                        action.item,
                        uiState.priceModifierPercentage
                    )
                }

                else -> {
                    viewModel.onAction(action)
                }
            }
        }
    )
}