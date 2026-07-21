package com.danidomenech.dndlootforge.feature.vendor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danidomenech.dndlootforge.domain.usecase.GetVendorItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class VendorViewModel @Inject constructor(
    private val getVendorItemsUseCase: GetVendorItemsUseCase
) : ViewModel() {

    private val playerLevel = MutableStateFlow(DEFAULT_PLAYER_LEVEL)

    val uiState: StateFlow<VendorUiState> = playerLevel
        .map { level ->
            VendorUiState(
                playerLevel = level,
                items = getVendorItemsUseCase(level)
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
            initialValue = VendorUiState()
        )

    fun onAction(action: VendorAction) {
        when (action) {
            is VendorAction.PlayerLevelChange -> {
                setPlayerLevel(action.playerLevel)
            }

            is VendorAction.ItemClick,
            is VendorAction.GenerateCatalogClick -> {
                // Handled by Route.
            }
        }
    }

    private fun setPlayerLevel(level: Int) {
        playerLevel.value = level.coerceIn(
            MIN_PLAYER_LEVEL,
            MAX_PLAYER_LEVEL
        )
    }

    companion object {
        const val DEFAULT_PLAYER_LEVEL = 1
        const val MIN_PLAYER_LEVEL = 1
        const val MAX_PLAYER_LEVEL = 20
        const val STOP_TIMEOUT_MILLIS = 5_000L
    }
}