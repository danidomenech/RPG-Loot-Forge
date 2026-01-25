package com.danidomenech.dndlootforge.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.ui.navigation.Screen
import com.danidomenech.dndlootforge.ui.screens.itemdetail.ItemDetailSheetContent
import com.danidomenech.dndlootforge.ui.screens.lootlist.LootListScreen
import com.danidomenech.dndlootforge.ui.screens.mainmenu.MainMenuScreen
import com.danidomenech.dndlootforge.ui.theme.DnDLootForgeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.danidomenech.dndlootforge.ui.screens.loottables.LootTablesScreen
import com.danidomenech.dndlootforge.ui.screens.narrativelootlist.NarrativeLootListScreen
import com.danidomenech.dndlootforge.ui.screens.vendorcatalog.CatalogScreen
import com.danidomenech.dndlootforge.ui.screens.vendor.VendorScreen

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MainActivityContent() {
    DnDLootForgeTheme {
        val navController = rememberNavController()
        val coroutineScope = rememberCoroutineScope()

        // Bottom Sheet State
        val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        var selectedItemData by remember {
            mutableStateOf<Pair<Item, Int?>?>(null)
        }

        // Click behavior shared across all screens
        val onItemClick: (Item, Int?) -> Unit = { item, priceModifier ->
            selectedItemData = item to priceModifier
            coroutineScope.launch { bottomSheetState.show() }
        }

        if (selectedItemData != null) {
            val (item, priceModifierPercent) = selectedItemData!!

            LaunchedEffect(selectedItemData) {
                bottomSheetState.show()
            }

            ModalBottomSheet(
                onDismissRequest = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                        selectedItemData = null
                    }
                },
                sheetState = bottomSheetState,
                dragHandle = null
            ) {
                ItemDetailSheetContent(
                    item = item,
                    priceModifierPercent = priceModifierPercent
                )
            }
        }


        NavHost(
            navController = navController,
            startDestination = Screen.MainMenu.route
        ) {
            composable(Screen.MainMenu.route) {
                MainMenuScreen(navController)
            }
            composable(Screen.AllItems.route) {
                LootListScreen(
                    onItemClick = onItemClick
                )
            }
            composable(Screen.LootTables.route) {
                LootTablesScreen(
                    onItemClick = onItemClick
                )
            }
            composable(Screen.NarrativeLootItems.route) {
                NarrativeLootListScreen(
                    onItemClick = onItemClick
                )
            }
            composable(Screen.VendorItems.route) {
                VendorScreen(
                    onItemClick = onItemClick,
                    navController = navController
                )
            }
            composable(Screen.CatalogItems.route) {
                CatalogScreen(
                    onItemClick = onItemClick,
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalMaterial3Api
fun DnDLootForgeAppPreview() {
    MainActivityContent()
}