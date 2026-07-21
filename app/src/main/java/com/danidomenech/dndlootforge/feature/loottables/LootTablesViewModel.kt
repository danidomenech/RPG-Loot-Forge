package com.danidomenech.dndlootforge.feature.loottables

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danidomenech.dndlootforge.domain.usecase.GenerateLootTablesUseCase
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class LootTablesViewModel @Inject constructor(
    getAllItemsUseCase: GetAllItemsUseCase,
    private val generateLootTablesUseCase: GenerateLootTablesUseCase
) : ViewModel() {

    private val allItems = MutableStateFlow(getAllItemsUseCase())
    private val showOnlyGear = MutableStateFlow(false)

    val uiState: StateFlow<LootTablesUiState> = combine(
        allItems,
        showOnlyGear
    ) { allItems, showOnlyGear ->
        LootTablesUiState(
            lootTables = generateLootTablesUseCase(
                items = allItems,
                showOnlyGear = showOnlyGear
            ),
            showOnlyGear = showOnlyGear
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
        initialValue = LootTablesUiState()
    )

    fun onAction(action: LootTablesAction) {
        when (action) {
            is LootTablesAction.ShowOnlyGearChange -> {
                setShowOnlyGear(action.showOnlyGear)
            }

            is LootTablesAction.ItemClick -> {
                // Handled by Route.
            }
        }
    }

    private fun setShowOnlyGear(onlyGear: Boolean) {
        showOnlyGear.value = onlyGear
    }

    private companion object {
        const val STOP_TIMEOUT_MILLIS = 5_000L
    }
}