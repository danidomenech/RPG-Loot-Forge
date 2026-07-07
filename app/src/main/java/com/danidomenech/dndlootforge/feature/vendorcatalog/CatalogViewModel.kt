package com.danidomenech.dndlootforge.feature.vendorcatalog

import android.app.Application
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.core.ui.BaseViewModel
import com.danidomenech.dndlootforge.domain.model.sortOrder
import com.danidomenech.dndlootforge.feature.vendor.typeOrder
import com.danidomenech.dndlootforge.domain.rules.LootTableRules
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
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

        val allowedTables = LootTableRules.getTablesForPlayerLevel(playerLevel)
        maxPowerLevel = allowedTables
            .mapNotNull { LootTableRules.lootTableRanges[it]?.last }
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
                { it.rarity.sortOrder }
            )
        )

        _catalogItems.value = sortedItems
    }

    fun rerollCatalog() = generateCatalog()


    fun setStockPercentage(percent: Int) {
        _uiState.update { it.copy(stockPercentage = percent.coerceIn(
            STOCK_MIN_PERCENT.toInt(), STOCK_MAX_PERCENT.toInt()
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
