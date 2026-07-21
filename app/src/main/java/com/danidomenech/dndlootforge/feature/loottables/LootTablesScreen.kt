package com.danidomenech.dndlootforge.feature.loottables

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.components.VerticalScrollbar
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.core.design.theme.UnevenRow
import com.danidomenech.dndlootforge.core.design.item.color
import com.danidomenech.dndlootforge.core.ui.text.toPlayerLevelText
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.LootTable
import com.danidomenech.dndlootforge.domain.model.LootTableEntry
import com.danidomenech.dndlootforge.domain.rules.LootTableRules
import com.danidomenech.dndlootforge.preview.fakeItems

private const val DICE_COLUMN_WEIGHT = 1f
private const val NAME_COLUMN_WEIGHT = 5f

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LootTablesScreen(
    uiState: LootTablesUiState,
    onAction: (LootTablesAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.loot_tables_screen_title))
                }
            )
        }
    ) { paddingValues ->
        LootTablesContent(
            lootTables = uiState.lootTables,
            showOnlyGear = uiState.showOnlyGear,
            onShowOnlyGearChanged = { showOnlyGear ->
                onAction(LootTablesAction.ShowOnlyGearChange(showOnlyGear))
            },
            onItemClick = { item ->
                onAction(LootTablesAction.ItemClick(item))
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun LootTablesContent(
    lootTables: Map<LootTable, List<LootTableEntry>>,
    showOnlyGear: Boolean,
    onShowOnlyGearChanged: (Boolean) -> Unit,
    onItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ShowOnlyGearFilter(
            checked = showOnlyGear,
            onCheckedChange = onShowOnlyGearChanged
        )

        Box(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(Dimensions.small),
                verticalArrangement = Arrangement.spacedBy(Dimensions.medium)
            ) {
                items(
                    items = lootTables.entries.toList(),
                    key = { (table, _) -> table.name }
                ) { (table, entries) ->
                    LootTableSection(
                        table = table,
                        entries = entries,
                        onItemClick = onItemClick
                    )
                }
            }

            VerticalScrollbar(
                listState = listState,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

@Composable
private fun ShowOnlyGearFilter(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start = Dimensions.medium,
            end = Dimensions.medium,
            bottom = Dimensions.small
        )
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )

        Text(stringResource(R.string.show_only_gear))
    }
}

@Composable
private fun LootTableSection(
    table: LootTable,
    entries: List<LootTableEntry>,
    onItemClick: (Item) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dimensions.medium)
    ) {
        LootTableHeader(table = table)

        LootTableColumnHeaders()

        entries.forEachIndexed { index, entry ->
            LootTableEntryRow(
                entry = entry,
                index = index,
                onClick = {
                    onItemClick(entry.item)
                }
            )
        }
    }
}

@Composable
private fun LootTableHeader(
    table: LootTable
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Dimensions.small,
                bottom = Dimensions.extraSmall
            )
    ) {
        Text(
            text = stringResource(
                R.string.loot_table_title,
                table.name
            ).uppercase(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = Dimensions.extraSmall)
        )

        Text(
            text = stringResource(
                R.string.loot_table_player_level,
                LootTableRules.playerLevelTables[table].toPlayerLevelText()
            ),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier
                .padding(
                    start = Dimensions.small,
                    end = Dimensions.extraSmall
                )
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun LootTableColumnHeaders() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimensions.medium,
                vertical = Dimensions.extraSmall
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.d100_title),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier
                .weight(DICE_COLUMN_WEIGHT)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(R.string.magic_item),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier
                .weight(NAME_COLUMN_WEIGHT)
                .padding(start = Dimensions.medium)
        )
    }
}

@Composable
private fun LootTableEntryRow(
    entry: LootTableEntry,
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
            text = entry.range,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(DICE_COLUMN_WEIGHT)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(entry.item.nameResId),
            color = entry.item.rarity.color,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(NAME_COLUMN_WEIGHT)
                .padding(start = Dimensions.medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LootTablesScreenPreview() {
    val lootTableEntriesA = listOf(
        LootTableEntry("1-70", fakeItems[0]),
        LootTableEntry("71-85", fakeItems[1]),
        LootTableEntry("86-95", fakeItems[2]),
        LootTableEntry("96-100", fakeItems[3])
    )

    val lootTableEntriesB = listOf(
        LootTableEntry("1-50", fakeItems[2]),
        LootTableEntry("51-100", fakeItems[3])
    )

    val lootTables = mapOf(
        LootTable.A to lootTableEntriesA,
        LootTable.B to lootTableEntriesB
    )

    DnDLootForgeTheme {
        LootTablesScreen(
            uiState = LootTablesUiState(
                lootTables = lootTables,
                showOnlyGear = false
            ),
            onAction = {}
        )
    }
}