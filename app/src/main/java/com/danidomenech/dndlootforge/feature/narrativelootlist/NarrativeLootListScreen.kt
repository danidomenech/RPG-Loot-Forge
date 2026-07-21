package com.danidomenech.dndlootforge.feature.narrativelootlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.core.design.theme.UnevenRow
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.rules.LootTableRules.getRequiredPlayerLevel
import com.danidomenech.dndlootforge.preview.fakeItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NarrativeLootListScreen(
    uiState: NarrativeLootListUiState,
    onAction: (NarrativeLootListAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.narrative_loot_list_screen_title))
                }
            )
        }
    ) { paddingValues ->
        NarrativeLootListContent(
            items = uiState.items,
            onItemClick = { item ->
                onAction(NarrativeLootListAction.ItemClick(item))
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun NarrativeLootListContent(
    items: List<Item>,
    onItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        NarrativeLootListHeader()

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
                    NarrativeItemRow(
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
                    .fillMaxSize()
            )
        }
    }
}

@Composable
private fun NarrativeLootListHeader() {
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
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.weight(NAME_COLUMN_WEIGHT)
        )

        Text(
            text = stringResource(R.string.player_level_recommended),
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT)
        )
    }
}

@Composable
private fun NarrativeItemRow(
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
            text = item.getRequiredPlayerLevel()?.toString() ?: "-",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NarrativeLootListScreenPreview() {
    DnDLootForgeTheme {
        NarrativeLootListScreen(
            uiState = NarrativeLootListUiState(
                items = fakeItems
            ),
            onAction = {}
        )
    }
}