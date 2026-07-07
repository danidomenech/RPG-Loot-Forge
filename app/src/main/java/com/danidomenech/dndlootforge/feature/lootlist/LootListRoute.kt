package com.danidomenech.dndlootforge.feature.lootlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danidomenech.dndlootforge.domain.model.Item

@Composable
fun LootListRoute(
    viewModel: LootListViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LootListScreen(
        uiState = uiState,
        onAction = { action ->
            when (action) {
                is LootListAction.ItemClick -> {
                    onItemClick(action.item, null)
                }
            }
        }
    )
}