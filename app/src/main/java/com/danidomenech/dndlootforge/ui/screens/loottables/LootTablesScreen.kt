package com.danidomenech.dndlootforge.ui.screens.loottables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.model.LootTable
import com.danidomenech.dndlootforge.data.model.LootTableEntry
import com.danidomenech.dndlootforge.ui.preview.fakeItems
import com.danidomenech.dndlootforge.ui.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.ui.theme.UnevenRow
import com.danidomenech.dndlootforge.ui.utils.TextHelper
import com.danidomenech.dndlootforge.ui.utils.TextHelper.getLootTablePlayerLevel
import com.danidomenech.dndlootforge.utils.ItemUtils

private const val DICE_COLUMN_WEIGHT = 1f
private const val NAME_COLUMN_WEIGHT = 5f

@ExperimentalMaterial3Api
@Composable
fun LootTablesScreen(
    viewModel: LootTablesViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val lootTables by viewModel.lootTables.collectAsState()
    val showOnlyGear by viewModel.showOnlyGear.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.loot_tables_screen_title)) })
        }
    ) { paddingValues ->
        LootTablesContent(
            lootTables = lootTables,
            onItemClick = onItemClick,
            showOnlyGear = showOnlyGear,
            onShowOnlyGearChanged = { viewModel.setShowOnlyGear(it) },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun LootTablesContent(
    lootTables: Map<LootTable, List<LootTableEntry>>,
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit,
    showOnlyGear: Boolean,
    onShowOnlyGearChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Checkbox(
                checked = showOnlyGear,
                onCheckedChange = onShowOnlyGearChanged
            )
            Text(stringResource(R.string.show_only_gear))
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            lootTables.forEach { (table, entries) ->
                item {
                    LootTableSection(
                        table = table,
                        entries = entries,
                        onItemClick = onItemClick
                    )
                }
            }
        }
    }
}

@Composable
fun LootTableSection(
    table: LootTable,
    entries: List<LootTableEntry>,
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 4.dp)
        ) {
            Text(
                text = stringResource(R.string.loot_table_title, table.name).uppercase(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 4.dp)
            )
            Text(
                text = stringResource(R.string.loot_table_player_level,
                    getLootTablePlayerLevel(ItemUtils.playerLevelTables[table] ?: 1..1)
                ),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier
                    .padding(start = 8.dp, end = 4.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        // Column headers
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.d100_title),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.ExtraBold),
                modifier = Modifier
                    .weight(DICE_COLUMN_WEIGHT)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.magic_item),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.ExtraBold),
                modifier = Modifier
                    .weight(NAME_COLUMN_WEIGHT)
                    .padding(start = 16.dp)
            )
        }

        // Rows
        entries.forEachIndexed { index, entry ->
            val item = entry.item
            val backgroundColor = if (index % 2 == 0) UnevenRow else Color.Transparent
            val range = entry.range

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .clickable { onItemClick(item, null) }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = range,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(DICE_COLUMN_WEIGHT)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
                Text(
                    text = context.getString(item.nameResId),
                    color = TextHelper.getRarityColor(item.rarity),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(NAME_COLUMN_WEIGHT)
                        .padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun LootTablesScreenPreview() {

    val fakeItems = fakeItems

    val lootTableEntriesA = listOf(
        LootTableEntry("1-70", fakeItems[0]),
        LootTableEntry("71-85", fakeItems[1]),
        LootTableEntry("86-95", fakeItems[2]),
        LootTableEntry("96-100", fakeItems[3])
    )

    // Optional: you can add other tables if you want to preview multiple
    val lootTableEntriesB = listOf(
        LootTableEntry("1-50", fakeItems[2]),
        LootTableEntry("51-100", fakeItems[3])
    )

    val lootTables = mapOf(
        LootTable.A to lootTableEntriesA,
        LootTable.B to lootTableEntriesB
    )

    DnDLootForgeTheme {
        LootTablesContent(

            lootTables = lootTables,
            onItemClick = { _, _ -> },
            showOnlyGear = false,
            onShowOnlyGearChanged = {}
        )
    }
}
