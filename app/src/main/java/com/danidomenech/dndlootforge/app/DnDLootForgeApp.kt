package com.danidomenech.dndlootforge.app

import androidx.compose.runtime.Composable
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.core.navigation.DnDLootForgeNavHost

@Composable
fun DnDLootForgeApp() {
    DnDLootForgeTheme {
        DnDLootForgeNavHost()
    }
}