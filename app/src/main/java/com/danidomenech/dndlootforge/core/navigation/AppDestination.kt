package com.danidomenech.dndlootforge.core.navigation

sealed class AppDestination(val route: String) {

    data object MainMenu : AppDestination("main_menu")

    data object AllItems : AppDestination("all_items")

    data object LootTables : AppDestination("loot_tables")

    data object NarrativeLootItems : AppDestination("narrative_loot_items")

    data object VendorItems : AppDestination("vendor_items")

    data object CatalogItems : AppDestination("catalog_items/{$PLAYER_LEVEL_ARG}") {
        fun createRoute(playerLevel: Int): String {
            return "catalog_items/$playerLevel"
        }
    }

    companion object {
        const val PLAYER_LEVEL_ARG = "playerLevel"
    }
}