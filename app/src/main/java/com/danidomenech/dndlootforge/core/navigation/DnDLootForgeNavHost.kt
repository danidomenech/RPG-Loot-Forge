package com.danidomenech.dndlootforge.core.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.feature.itemdetail.ItemDetailSheetContent
import com.danidomenech.dndlootforge.feature.lootlist.LootListRoute
import com.danidomenech.dndlootforge.feature.loottables.LootTablesRoute
import com.danidomenech.dndlootforge.feature.mainmenu.MainMenuRoute
import com.danidomenech.dndlootforge.feature.narrativelootlist.NarrativeLootListRoute
import com.danidomenech.dndlootforge.feature.vendor.VendorRoute
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DnDLootForgeNavHost(
    navController: NavHostController = rememberNavController()
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var selectedItemDetail by remember {
        mutableStateOf<SelectedItemDetail?>(null)
    }

    val onItemClick: (Item, Int?) -> Unit = { item, priceModifier ->
        selectedItemDetail = SelectedItemDetail(
            item = item,
            priceModifierPercent = priceModifier
        )
    }

    selectedItemDetail?.let { itemDetail ->
        LaunchedEffect(itemDetail.item.id.value, itemDetail.priceModifierPercent) {
            bottomSheetState.show()
        }

        ModalBottomSheet(
            onDismissRequest = {
                coroutineScope.launch {
                    bottomSheetState.hide()
                    selectedItemDetail = null
                }
            },
            sheetState = bottomSheetState,
            dragHandle = null
        ) {
            ItemDetailSheetContent(
                item = itemDetail.item,
                priceModifierPercent = itemDetail.priceModifierPercent
            )
        }
    }

    NavHost(
        navController = navController,
        startDestination = AppDestination.MainMenu.route
    ) {
        composable(AppDestination.MainMenu.route) {
            MainMenuRoute(
                onNavigateToAllItems = {
                    navController.navigate(AppDestination.AllItems.route)
                },
                onNavigateToLootTables = {
                    navController.navigate(AppDestination.LootTables.route)
                },
                onNavigateToNarrativeLootItems = {
                    navController.navigate(AppDestination.NarrativeLootItems.route)
                },
                onNavigateToVendorItems = {
                    navController.navigate(AppDestination.VendorItems.route)
                }
            )
        }

        composable(AppDestination.AllItems.route) {
            LootListRoute(
                onItemClick = onItemClick
            )
        }

        composable(AppDestination.LootTables.route) {
            LootTablesRoute(
                onItemClick = onItemClick
            )
        }

        composable(AppDestination.NarrativeLootItems.route) {
            NarrativeLootListRoute(
                onItemClick = onItemClick
            )
        }

        composable(AppDestination.VendorItems.route) {
            VendorRoute(
                onItemClick = onItemClick,
                onGenerateCatalogClick = { playerLevel ->
                    navController.navigate(
                        AppDestination.CatalogItems.createRoute(playerLevel)
                    )
                }
            )
        }

        composable(
            route = AppDestination.CatalogItems.route,
            arguments = listOf(
                navArgument(AppDestination.PLAYER_LEVEL_ARG) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val playerLevel = backStackEntry.arguments
                ?.getInt(AppDestination.PLAYER_LEVEL_ARG)
                ?: 1

            CatalogRoute(
                playerLevel = playerLevel,
                onItemClick = onItemClick
            )
        }
    }
}

private data class SelectedItemDetail(
    val item: Item,
    val priceModifierPercent: Int?
)