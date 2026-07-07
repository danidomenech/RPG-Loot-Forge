package com.danidomenech.dndlootforge.feature.mainmenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuScreen(
    onAllItemsClick: () -> Unit,
    onLootTablesClick: () -> Unit,
    onNarrativeLootItemsClick: () -> Unit,
    onVendorItemsClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.main_menu_title)) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onAllItemsClick) {
                Text(stringResource(R.string.all_items_screen_title))
            }

            Button(onClick = onLootTablesClick) {
                Text(stringResource(R.string.loot_tables_screen_title))
            }

            Button(onClick = onNarrativeLootItemsClick) {
                Text(stringResource(R.string.narrative_loot_list_screen_title))
            }

            Button(onClick = onVendorItemsClick) {
                Text(stringResource(R.string.vendor_screen_title))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainMenuScreenPreview() {
    DnDLootForgeTheme {
        MainMenuScreen(
            onAllItemsClick = {},
            onLootTablesClick = {},
            onNarrativeLootItemsClick = {},
            onVendorItemsClick = {}
        )
    }
}