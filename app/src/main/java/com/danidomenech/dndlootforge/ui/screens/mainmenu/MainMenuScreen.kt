package com.danidomenech.dndlootforge.ui.screens.mainmenu

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.ui.navigation.Screen

@ExperimentalMaterial3Api
@Composable
fun MainMenuScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.main_menu_title)) })
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
            Button(onClick = { navController.navigate(Screen.AllItems.route) }) {
                Text(stringResource(R.string.all_items_screen_title))
            }
            Button(onClick = { navController.navigate(Screen.LootTables.route) }) {
                Text(stringResource(R.string.loot_tables_screen_title))
            }
            Button(onClick = { navController.navigate(Screen.NarrativeLootItems.route) }) {
                Text(stringResource(R.string.narrative_loot_list_screen_title))
            }
            Button(onClick = { navController.navigate(Screen.VendorItems.route) }) {
                Text(stringResource(R.string.vendor_screen_title))
            }
        }
    }
}