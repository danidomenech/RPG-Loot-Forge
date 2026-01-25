package com.danidomenech.dndlootforge.ui.navigation

sealed class Screen(val route: String) {
    object MainMenu : Screen("main_menu")
    object AllItems : Screen("all_items")
    object LootTables : Screen("loot_tables")
    object NarrativeLootItems : Screen("narrative_loot_items")
    object VendorItems : Screen("vendor_items")
    object CatalogItems : Screen("catalog_items")
}