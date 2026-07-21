package com.danidomenech.dndlootforge.feature.loottables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danidomenech.dndlootforge.domain.model.Item

@Composable
fun LootTablesRoute(
    viewModel: LootTablesViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LootTablesScreen(
        uiState = uiState,
        onAction = { action ->
            when (action) {
                is LootTablesAction.ShowOnlyGearChange -> {
                    viewModel.onAction(action)
                }

                is LootTablesAction.ItemClick -> {
                    onItemClick(action.item, null)
                }
            }
        }
    )
}