package com.danidomenech.dndlootforge.feature.narrativelootlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danidomenech.dndlootforge.domain.model.Item

@Composable
fun NarrativeLootListRoute(
    viewModel: NarrativeLootListViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NarrativeLootListScreen(
        uiState = uiState,
        onAction = { action ->
            when (action) {
                is NarrativeLootListAction.ItemClick -> {
                    onItemClick(action.item, null)
                }
            }
        }
    )
}