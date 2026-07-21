package com.danidomenech.dndlootforge.feature.vendorcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.components.NAME_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.TYPE_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.VerticalScrollbar
import com.danidomenech.dndlootforge.core.design.item.color
import com.danidomenech.dndlootforge.core.design.item.text
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.core.design.theme.UnevenRow
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.preview.fakeItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    uiState: CatalogUiState,
    onAction: (CatalogAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.catalog_screen_title))
                }
            )
        }
    ) { paddingValues ->
        CatalogListContent(
            uiState = uiState,
            onStockChange = { percentage ->
                onAction(CatalogAction.StockPercentageChange(percentage))
            },
            onPriceModifierChange = { percentage ->
                onAction(CatalogAction.PriceModifierChange(percentage))
            },
            onGenerateClick = {
                onAction(CatalogAction.GenerateCatalogClick)
            },
            onRerollClick = {
                onAction(CatalogAction.RerollCatalogClick)
            },
            onEditFiltersClick = {
                onAction(CatalogAction.EditModifiersClick)
            },
            onItemClick = { item ->
                onAction(CatalogAction.ItemClick(item))
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun CatalogListContent(
    uiState: CatalogUiState,
    onStockChange: (Int) -> Unit,
    onPriceModifierChange: (Int) -> Unit,
    onGenerateClick: () -> Unit,
    onRerollClick: () -> Unit,
    onEditFiltersClick: () -> Unit,
    onItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (!uiState.catalogGenerated) {
            CatalogFiltersContent(
                uiState = uiState,
                onStockChange = onStockChange,
                onPriceModifierChange = onPriceModifierChange,
                onGenerateClick = onGenerateClick
            )
        } else {
            GeneratedCatalogContent(
                items = uiState.items,
                onRerollClick = onRerollClick,
                onEditFiltersClick = onEditFiltersClick,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun CatalogFiltersContent(
    uiState: CatalogUiState,
    onStockChange: (Int) -> Unit,
    onPriceModifierChange: (Int) -> Unit,
    onGenerateClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(
            horizontal = Dimensions.extraLarge,
            vertical = Dimensions.medium
        )
    ) {
        Text(
            text = stringResource(
                R.string.vendor_stock_modifier,
                uiState.stockPercentage
            ),
            style = MaterialTheme.typography.bodyLarge
        )

        Slider(
            value = uiState.stockPercentage.toFloat(),
            onValueChange = { value ->
                onStockChange(value.toInt())
            },
            valueRange = CatalogDefaults.STOCK_MIN_PERCENT.toFloat()..CatalogDefaults.STOCK_MAX_PERCENT.toFloat(),
            steps = CatalogDefaults.STOCK_STEPS
        )

        Spacer(modifier = Modifier.height(Dimensions.medium))

        Text(
            text = stringResource(
                R.string.vendor_price_modifier,
                uiState.priceModifierPercentage
            ),
            style = MaterialTheme.typography.bodyLarge
        )

        Slider(
            value = uiState.priceModifierPercentage.toFloat(),
            onValueChange = { value ->
                onPriceModifierChange(value.toInt())
            },
            valueRange = CatalogDefaults.PRICE_MIN_PERCENT.toFloat()..CatalogDefaults.PRICE_MAX_PERCENT.toFloat(),
            steps = CatalogDefaults.PRICE_STEPS
        )

        Spacer(modifier = Modifier.height(Dimensions.medium))

        Button(
            onClick = onGenerateClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(R.string.generate_catalog))
        }
    }
}

@Composable
private fun GeneratedCatalogContent(
    items: List<Item>,
    onRerollClick: () -> Unit,
    onEditFiltersClick: () -> Unit,
    onItemClick: (Item) -> Unit
) {
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CatalogActionsHeader(
            onRerollClick = onRerollClick,
            onEditFiltersClick = onEditFiltersClick
        )

        CatalogColumnHeaders()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(Dimensions.small),
                verticalArrangement = Arrangement.spacedBy(Dimensions.extraSmall)
            ) {
                itemsIndexed(
                    items = items,
                    key = { _, item -> item.id.value }
                ) { index, item ->
                    CatalogItemRow(
                        item = item,
                        index = index,
                        onClick = { onItemClick(item) }
                    )
                }
            }

            VerticalScrollbar(
                listState = listState,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .matchParentSize()
            )
        }
    }
}

@Composable
private fun CatalogActionsHeader(
    onRerollClick: () -> Unit,
    onEditFiltersClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.medium),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onRerollClick) {
            Text(stringResource(R.string.reroll_catalog))
        }

        Button(onClick = onEditFiltersClick) {
            Text(stringResource(R.string.edit_modifiers))
        }
    }
}

@Composable
private fun CatalogColumnHeaders() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimensions.medium,
                vertical = Dimensions.small
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.magic_item),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.weight(NAME_COLUMN_WEIGHT)
        )

        Text(
            text = stringResource(R.string.type),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT)
        )
    }
}

@Composable
private fun CatalogItemRow(
    item: Item,
    index: Int,
    onClick: () -> Unit
) {
    val backgroundColor = if (index % 2 == 0) {
        UnevenRow
    } else {
        Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(
                horizontal = Dimensions.medium,
                vertical = Dimensions.small
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(item.nameResId),
            color = item.rarity.color,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(NAME_COLUMN_WEIGHT)
                .padding(end = Dimensions.small)
        )

        Text(
            text = item.type.text(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT)
        )
    }
}

object CatalogDefaults {
    const val DEFAULT_STOCK_PERCENTAGE = 50
    const val DEFAULT_PRICE_MODIFIER_PERCENTAGE = 0

    const val STOCK_MIN_PERCENT = 0
    const val STOCK_MAX_PERCENT = 100
    const val STOCK_JUMP_DISTANCE = 10

    const val PRICE_MIN_PERCENT = -100
    const val PRICE_MAX_PERCENT = 300
    const val PRICE_JUMP_DISTANCE = 5

    const val STOCK_STEPS =
        (STOCK_MAX_PERCENT - STOCK_MIN_PERCENT) / STOCK_JUMP_DISTANCE - 1

    const val PRICE_STEPS =
        (PRICE_MAX_PERCENT - PRICE_MIN_PERCENT) / PRICE_JUMP_DISTANCE - 1
}

@Preview(showBackground = true)
@Composable
private fun CatalogScreenPreview() {
    DnDLootForgeTheme {
        CatalogScreen(
            uiState = CatalogUiState(
                items = fakeItems,
                stockPercentage = 50,
                priceModifierPercentage = 0,
                catalogGenerated = true
            ),
            onAction = {}
        )
    }
}