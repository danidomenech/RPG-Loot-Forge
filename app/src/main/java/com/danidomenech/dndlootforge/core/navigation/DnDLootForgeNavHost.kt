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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.feature.itemdetail.ItemDetailSheetContent
import com.danidomenech.dndlootforge.feature.lootlist.LootListRoute
import com.danidomenech.dndlootforge.feature.loottables.LootTablesRoute
import com.danidomenech.dndlootforge.feature.mainmenu.MainMenuRoute
import com.danidomenech.dndlootforge.feature.narrativelootlist.NarrativeLootListScreen
import com.danidomenech.dndlootforge.feature.vendor.VendorScreen
import com.danidomenech.dndlootforge.feature.vendor.VendorViewModel
import com.danidomenech.dndlootforge.feature.vendorcatalog.CatalogScreen
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
            NarrativeLootListScreen(
                onItemClick = onItemClick
            )
        }

        composable(AppDestination.VendorItems.route) {
            VendorScreen(
                onItemClick = onItemClick,
                onGenerateCatalogClick = {
                    navController.navigate(AppDestination.CatalogItems.route)
                }
            )
        }

        composable(AppDestination.CatalogItems.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(AppDestination.VendorItems.route)
            }

            val vendorViewModel: VendorViewModel = hiltViewModel(parentEntry)

            CatalogScreen(
                vendorViewModel = vendorViewModel,
                onItemClick = onItemClick
            )
        }
    }
}

private data class SelectedItemDetail(
    val item: Item,
    val priceModifierPercent: Int?
)