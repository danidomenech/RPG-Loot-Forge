package com.danidomenech.dndlootforge.feature.lootlist

import android.content.Context
import androidx.lifecycle.ViewModel
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootListFilters
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import com.danidomenech.dndlootforge.domain.usecase.FilterItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LootListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getAllItemsUseCase: GetAllItemsUseCase,
    private val filterItemsUseCase: FilterItemsUseCase
) : ViewModel() {

    private val allItems: List<Item> = getAllItemsUseCase()
        .sortedBy { item ->
            context.getString(item.nameResId).lowercase()
        }

    private val _uiState = MutableStateFlow(
        LootListUiState(
            items = allItems,
            totalItems = allItems
        )
    )

    val uiState: StateFlow<LootListUiState> = _uiState.asStateFlow()

    fun onAction(action: LootListAction) {
        when (action) {
            is LootListAction.ApplyFilters -> {
                _uiState.value = _uiState.value.copy(
                    filters = action.filters,
                    items = filterItemsUseCase(allItems, action.filters)
                )
            }

            is LootListAction.ItemClick -> {
                // Handled by Route.
            }
        }
    }

    fun getMatchingCount(filters: LootListFilters): Int {
        return filterItemsUseCase(allItems, filters).size
    }
}