package com.danidomenech.dndlootforge.feature.mainmenu

import androidx.compose.runtime.Composable

@Composable
fun MainMenuRoute(
    onNavigateToAllItems: () -> Unit,
    onNavigateToLootTables: () -> Unit,
    onNavigateToNarrativeLootItems: () -> Unit,
    onNavigateToVendorItems: () -> Unit
) {
    MainMenuScreen(
        onAllItemsClick = onNavigateToAllItems,
        onLootTablesClick = onNavigateToLootTables,
        onNarrativeLootItemsClick = onNavigateToNarrativeLootItems,
        onVendorItemsClick = onNavigateToVendorItems
    )
}