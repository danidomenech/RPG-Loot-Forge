package com.danidomenech.dndlootforge.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun rememberParentEntry(route: String, navController: NavController): NavBackStackEntry {
    return remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry(route)
    }
}