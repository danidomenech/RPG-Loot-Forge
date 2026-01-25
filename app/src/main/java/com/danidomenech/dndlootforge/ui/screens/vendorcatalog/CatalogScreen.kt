package com.danidomenech.dndlootforge.ui.screens.vendorcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.ui.navigation.Screen
import com.danidomenech.dndlootforge.ui.preview.fakeItems
import com.danidomenech.dndlootforge.ui.screens.vendor.VendorViewModel
import com.danidomenech.dndlootforge.ui.screens.vendorcatalog.CatalogViewModel.Companion.PRICE_MAX_PERCENT
import com.danidomenech.dndlootforge.ui.screens.vendorcatalog.CatalogViewModel.Companion.PRICE_MIN_PERCENT
import com.danidomenech.dndlootforge.ui.screens.vendorcatalog.CatalogViewModel.Companion.STOCK_MAX_PERCENT
import com.danidomenech.dndlootforge.ui.screens.vendorcatalog.CatalogViewModel.Companion.STOCK_MIN_PERCENT
import com.danidomenech.dndlootforge.ui.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.ui.theme.UnevenRow
import com.danidomenech.dndlootforge.ui.utils.TextHelper
import com.danidomenech.dndlootforge.ui.utils.rememberParentEntry

private const val NAME_COLUMN_WEIGHT = 2f
private const val TYPE_COLUMN_WEIGHT = 1f

@ExperimentalMaterial3Api
@Composable
fun CatalogScreen(
    navController: NavController,
    catalogViewModel: CatalogViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val parentEntry = rememberParentEntry(Screen.VendorItems.route, navController)
    val vendorViewModel: VendorViewModel = hiltViewModel(parentEntry)

    val itemsFullList by vendorViewModel.vendorItems.collectAsState()
    val playerLevel by vendorViewModel.playerLevel.collectAsState()
    val catalogItems by catalogViewModel.catalogItems.collectAsState()
    val uiState by catalogViewModel.uiState.collectAsState()

    LaunchedEffect(itemsFullList, playerLevel) {
        if (itemsFullList.isNotEmpty()) {
            catalogViewModel.setVendorItemsAndPlayerLevel(itemsFullList, playerLevel)
        }
    }

    CatalogListContent(
        itemsFullList = catalogItems,
        onItemClick = onItemClick,
        onRerollClick = { catalogViewModel.rerollCatalog() },
        uiState = uiState,
        onStockChange = catalogViewModel::setStockPercentage,
        onPriceModifierChange = catalogViewModel::setPriceModifier,
        onGenerateClick = {
            catalogViewModel.markCatalogGenerated()
            catalogViewModel.rerollCatalog()
        },
        onEditFiltersClick = catalogViewModel::resetCatalogState,
        stockSteps = catalogViewModel.getStockSteps(),
        priceSteps = catalogViewModel.getPriceSteps()
    )
}

@ExperimentalMaterial3Api
@Composable
fun CatalogListContent(
    itemsFullList: List<Item>,
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit,
    onRerollClick: () -> Unit,
    uiState: CatalogViewModel.CatalogUiState,
    onStockChange: (Int) -> Unit,
    onPriceModifierChange: (Int) -> Unit,
    onGenerateClick: () -> Unit,
    onEditFiltersClick: () -> Unit,
    stockSteps: Int,
    priceSteps: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.catalog_screen_title)) })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            if (!uiState.catalogGenerated) {
                // Filters Section
                Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp)) {
                    Text(stringResource(R.string.vendor_stock_modifier, uiState.stockPercentage), style = MaterialTheme.typography.bodyLarge)
                    Slider(
                        value = uiState.stockPercentage.toFloat(),
                        onValueChange = { onStockChange(it.toInt()) },
                        valueRange = STOCK_MIN_PERCENT..STOCK_MAX_PERCENT,
                        steps = stockSteps
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(stringResource(R.string.vendor_price_modifier, uiState.priceModifierPercentage), style = MaterialTheme.typography.bodyLarge)
                    Slider(
                        value = uiState.priceModifierPercentage.toFloat(),
                        onValueChange = { onPriceModifierChange(it.toInt()) },
                        valueRange = PRICE_MIN_PERCENT..PRICE_MAX_PERCENT,
                        steps = priceSteps
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onGenerateClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(stringResource(R.string.generate_catalog))
                }
            } else {
                // Reroll + Edit Filters
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onRerollClick) {
                        Text(stringResource(R.string.reroll_catalog))
                    }
                    Button(onClick = onEditFiltersClick) {
                        Text(stringResource(R.string.edit_modifiers))
                    }
                }

                // Column Headers
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.magic_item),
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.ExtraBold),
                        modifier = Modifier.weight(NAME_COLUMN_WEIGHT)
                    )
                    Text(
                        text = stringResource(R.string.type),
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.ExtraBold),
                        modifier = Modifier.weight(TYPE_COLUMN_WEIGHT),
                    )
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    itemsIndexed(itemsFullList, key = { _, item -> item.id }) { index, item ->
                        CatalogItemRow(
                            item = item,
                            index = index,
                            onClick = { onItemClick(item, uiState.priceModifierPercentage) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CatalogItemRow(
    item: Item,
    index: Int,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val backgroundColor = if (index % 2 == 0) UnevenRow else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = context.getString(item.nameResId),
            color = TextHelper.getRarityColor(item.rarity),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(NAME_COLUMN_WEIGHT)
                .padding(end = 8.dp)
        )

        Text(
            text = TextHelper.getItemTypeString(item.type),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT),
        )
    }
}



//PREVIEWS
@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun CatalogScreenPreview() {

    val fakeItems = fakeItems

    val fakeUiState = CatalogViewModel.CatalogUiState(
        stockPercentage = 50,
        priceModifierPercentage = 0,
        catalogGenerated = true // Toggle to true to test generated state
    )

    DnDLootForgeTheme {
        CatalogListContent(
            itemsFullList = fakeItems,
            onItemClick = { _, _ -> },
            onRerollClick = {},
            uiState = fakeUiState,
            onStockChange = {},
            onPriceModifierChange = {},
            onGenerateClick = {},
            onEditFiltersClick = {},
            stockSteps = 9,
            priceSteps = 79
        )
    }
}