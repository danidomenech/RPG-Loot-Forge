package com.danidomenech.dndlootforge.feature.vendorcatalog

import androidx.lifecycle.ViewModel
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.usecase.GenerateVendorCatalogUseCase
import com.danidomenech.dndlootforge.domain.usecase.GetVendorItemsUseCase
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogDefaults.PRICE_MAX_PERCENT
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogDefaults.PRICE_MIN_PERCENT
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogDefaults.STOCK_MAX_PERCENT
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogDefaults.STOCK_MIN_PERCENT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getVendorItemsUseCase: GetVendorItemsUseCase,
    private val generateVendorCatalogUseCase: GenerateVendorCatalogUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CatalogUiState())
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    private var playerLevel: Int = DEFAULT_PLAYER_LEVEL
    private var vendorItems: List<Item> = emptyList()

    fun setPlayerLevel(playerLevel: Int) {
        if (this.playerLevel == playerLevel && vendorItems.isNotEmpty()) return

        this.playerLevel = playerLevel
        vendorItems = getVendorItemsUseCase(playerLevel)

        resetCatalogState()
    }

    fun onAction(action: CatalogAction) {
        when (action) {
            is CatalogAction.StockPercentageChange -> {
                setStockPercentage(action.percentage)
            }

            is CatalogAction.PriceModifierChange -> {
                setPriceModifier(action.percentage)
            }

            CatalogAction.GenerateCatalogClick -> {
                generateCatalog()
            }

            CatalogAction.RerollCatalogClick -> {
                rerollCatalog()
            }

            CatalogAction.EditModifiersClick -> {
                resetCatalogState()
            }

            is CatalogAction.ItemClick -> {
                // Handled by Route.
            }
        }
    }

    private fun generateCatalog() {
        val currentState = _uiState.value

        _uiState.update {
            it.copy(
                catalogGenerated = true,
                items = generateVendorCatalogUseCase(
                    vendorItems = vendorItems,
                    playerLevel = playerLevel,
                    stockPercentage = currentState.stockPercentage
                )
            )
        }
    }

    private fun rerollCatalog() {
        val currentState = _uiState.value

        _uiState.update {
            it.copy(
                items = generateVendorCatalogUseCase(
                    vendorItems = vendorItems,
                    playerLevel = playerLevel,
                    stockPercentage = currentState.stockPercentage
                )
            )
        }
    }

    private fun setStockPercentage(percent: Int) {
        _uiState.update {
            it.copy(
                stockPercentage = percent.coerceIn(
                    STOCK_MIN_PERCENT,
                    STOCK_MAX_PERCENT
                )
            )
        }
    }

    private fun setPriceModifier(percent: Int) {
        _uiState.update {
            it.copy(
                priceModifierPercentage = percent.coerceIn(
                    PRICE_MIN_PERCENT,
                    PRICE_MAX_PERCENT
                )
            )
        }
    }

    private fun resetCatalogState() {
        _uiState.update {
            it.copy(
                catalogGenerated = false,
                items = emptyList()
            )
        }
    }

    private companion object {
        const val DEFAULT_PLAYER_LEVEL = 1
    }
}