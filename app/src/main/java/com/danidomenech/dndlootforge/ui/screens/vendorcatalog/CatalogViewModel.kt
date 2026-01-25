package com.danidomenech.dndlootforge.ui.screens.vendorcatalog

import android.app.Application
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.ui.base.BaseViewModel
import com.danidomenech.dndlootforge.ui.utils.typeOrder
import com.danidomenech.dndlootforge.utils.ItemUtils
import com.danidomenech.dndlootforge.utils.ItemUtils.rarityOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

@HiltViewModel
class CatalogViewModel @Inject constructor(
    application: Application,
) : BaseViewModel(application) {

    private val _catalogItems = MutableStateFlow<List<Item>>(emptyList())
    val catalogItems: StateFlow<List<Item>> = _catalogItems

    private val _uiState = MutableStateFlow(CatalogUiState())
    val uiState: StateFlow<CatalogUiState> = _uiState

    private var fullVendorList: List<Item> = emptyList()
    private var maxPowerLevel: Int = 0

    fun setVendorItemsAndPlayerLevel(items: List<Item>, playerLevel: Int) {
        fullVendorList = items

        val allowedTables = ItemUtils.getTablesForPlayerLevel(playerLevel)
        maxPowerLevel = allowedTables
            .mapNotNull { ItemUtils.lootTableRanges[it]?.last }
            .maxOrNull() ?: 0
    }

    private fun generateCatalog() {
        val stockPercentage = _uiState.value.stockPercentage
        val random = Random.Default

        val result = when (stockPercentage) {
            0 -> emptyList()
            100 -> fullVendorList
            else -> {
                val multiplier = stockPercentage / 50f // 50% = x1.0, 25% = x0.5, 100% = guaranteed

                fullVendorList.filter { item ->
                    val powerLevel = item.powerLevel.coerceAtMost(maxPowerLevel)
                    val baseChance = (maxPowerLevel + 1) - powerLevel

                    val rawChance = if (baseChance <= 100) {
                        baseChance.coerceIn(0, 100)
                    } else {
                        val firstDigit = baseChance.toString().first().digitToInt()
                        val extraMultiplier = firstDigit + 1
                        val remainder = baseChance % 100
                        (remainder * extraMultiplier).coerceIn(0, 100)
                    }

                    val adjustedChance = (rawChance * multiplier).toInt().coerceIn(0, 100)

                    random.nextInt(0, 100) < adjustedChance
                }
            }
        }

        val sortedItems = result.sortedWith(
            compareBy(
                { typeOrder.indexOf(it.type) },
                { rarityOrder.indexOf(it.rarity) }
            )
        )

        _catalogItems.value = sortedItems
    }

    fun rerollCatalog() = generateCatalog()


    fun setStockPercentage(percent: Int) {
        _uiState.update { it.copy(stockPercentage = percent.coerceIn(STOCK_MIN_PERCENT.toInt(), STOCK_MAX_PERCENT.toInt()
        )) }
    }

    fun setPriceModifier(percent: Int) {
        _uiState.update { it.copy(priceModifierPercentage = percent.coerceIn(PRICE_MIN_PERCENT.toInt(), PRICE_MAX_PERCENT.toInt())) }
    }

    fun markCatalogGenerated() {
        _uiState.update { it.copy(catalogGenerated = true) }
    }

    fun resetCatalogState() {
        _uiState.update { it.copy(catalogGenerated = false) }
        _catalogItems.value = emptyList()
    }

    fun getStockSteps() : Int {
        return (STOCK_MAX_PERCENT.toInt() - STOCK_MIN_PERCENT.toInt()) / STOCK_JUMP_DISTANCE - 1
    }

    fun getPriceSteps() : Int {
        return (PRICE_MAX_PERCENT.toInt() - PRICE_MIN_PERCENT.toInt()) / PRICE_JUMP_DISTANCE - 1
    }

    data class CatalogUiState(
        val catalogGenerated: Boolean = false,
        val stockPercentage: Int = 50,
        val priceModifierPercentage: Int = 0
    )

    companion object {
        const val STOCK_MIN_PERCENT = 0f
        const val STOCK_MAX_PERCENT = 100f
        const val STOCK_JUMP_DISTANCE = 10

        const val PRICE_MIN_PERCENT = -100f
        const val PRICE_MAX_PERCENT = 300f
        const val PRICE_JUMP_DISTANCE = 5
    }

}
