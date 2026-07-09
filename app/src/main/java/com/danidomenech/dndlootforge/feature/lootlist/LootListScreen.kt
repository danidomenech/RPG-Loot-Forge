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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danidomenech.dndlootforge.domain.model.Item
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LootListScreen(
    uiState: LootListUiState,
    onAction: (LootListAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.all_items_screen_title))
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
                    .padding(vertical = Dimensions.small)
            )
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

@Preview(showBackground = true)
@Composable
private fun LootListScreenPreview() {
    DnDLootForgeTheme {
        LootListScreen(
            uiState = LootListUiState(
                items = fakeItems
            ),
            onAction = {}
        )
    }
}