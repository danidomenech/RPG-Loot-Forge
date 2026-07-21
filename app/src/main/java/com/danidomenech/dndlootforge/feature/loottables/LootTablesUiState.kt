package com.danidomenech.dndlootforge.feature.loottables

import com.danidomenech.dndlootforge.domain.model.LootTable
import com.danidomenech.dndlootforge.domain.model.LootTableEntry

data class LootTablesUiState(
    val lootTables: Map<LootTable, List<LootTableEntry>> = emptyMap(),
    val showOnlyGear: Boolean = false
)