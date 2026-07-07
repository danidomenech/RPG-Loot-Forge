package com.danidomenech.dndlootforge.feature.lootlist

import android.content.Context
import androidx.lifecycle.ViewModel
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LootListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getAllItemsUseCase: GetAllItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LootListUiState())
    val uiState: StateFlow<LootListUiState> = _uiState.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        val items = getAllItemsUseCase()
            .sortedBy { item ->
                context.getString(item.nameResId).lowercase()
            }

        _uiState.value = LootListUiState(
            items = items
        )
    }
}