package com.danidomenech.dndlootforge.feature.lootlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danidomenech.dndlootforge.domain.model.Item
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.components.ItemRow
import com.danidomenech.dndlootforge.core.design.components.NAME_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.TYPE_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.VerticalScrollbar
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.preview.fakeItems
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.feature.lootlist.filters.LootListFilterSheet
import com.danidomenech.dndlootforge.domain.model.LootListFilters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LootListScreen(
    uiState: LootListUiState,
    getMatchingCount: (LootListFilters) -> Int,
    onAction: (LootListAction) -> Unit
) {
    var showFilters by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.all_items_screen_title))
                },
                actions = {
                    IconButton(
                        onClick = { showFilters = true }
                    ) {
                        BadgedBox(
                            badge = {
                                if (uiState.hasActiveFilters) {
                                    Badge()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.FilterList,
                                contentDescription = stringResource(R.string.filter_sheet_filters)
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        LootListContent(
            items = uiState.items,
            onItemClick = { item ->
                onAction(LootListAction.ItemClick(item))
            },
            modifier = Modifier.padding(paddingValues)
        )
    }

    if (showFilters) {
        LootListFilterSheet(
            filters = uiState.filters,
            getMatchingCount = getMatchingCount,
            onApplyFilters = { filters ->
                onAction(LootListAction.ApplyFilters(filters))
            },
            onDismiss = { showFilters = false }
        )
    }
}

@Composable
private fun LootListContent(
    items: List<Item>,
    onItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    Column(modifier = modifier) {
        LootListHeader()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (items.isEmpty()) {
                Text(
                    text = stringResource(R.string.no_items_found),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
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
                        ItemRow(
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
                        .padding(vertical = Dimensions.small)
                )
            }
        }
    }
}

@Composable
private fun LootListHeader() {
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

@Preview(
    name = "All Items - Default",
    showBackground = true
)
@Composable
private fun LootListScreenPreview() {
    DnDLootForgeTheme {
        LootListScreen(
            uiState = LootListUiState(
                items = fakeItems
            ),
            getMatchingCount = { filters ->
                fakeItems.count { item ->
                    filters.rarities.isEmpty() || item.rarity in filters.rarities
                }
            },
            onAction = {}
        )
    }
}

@Preview(
    name = "All Items - No Results",
    showBackground = true
)
@Composable
private fun LootListNoResultsPreview() {
    DnDLootForgeTheme {
        LootListScreen(
            uiState = LootListUiState(
                items = emptyList(),
                filters = LootListFilters(
                    rarities = setOf(ItemRarity.LEGENDARY)
                )
            ),
            getMatchingCount = { filters ->
                fakeItems.count { item ->
                    filters.rarities.isEmpty() || item.rarity in filters.rarities
                }
            },
            onAction = {}
        )
    }
}