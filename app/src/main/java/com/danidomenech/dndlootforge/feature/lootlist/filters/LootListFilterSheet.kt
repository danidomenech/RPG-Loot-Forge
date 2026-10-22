package com.danidomenech.dndlootforge.feature.lootlist.filters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.item.color
import com.danidomenech.dndlootforge.core.design.item.text
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.domain.model.ItemRarity
import com.danidomenech.dndlootforge.domain.model.LootListFilters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LootListFilterSheet(
    filters: LootListFilters,
    getMatchingCount: (LootListFilters) -> Int,
    onApplyFilters: (LootListFilters) -> Unit,
    onDismiss: () -> Unit
) {
    var draftFilters by remember {
        mutableStateOf(filters)
    }

    val matchingCount = remember(draftFilters, getMatchingCount) {
        getMatchingCount(draftFilters)
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {
        LootListFilterContent(
            filters = draftFilters,
            matchingCount = matchingCount,
            onRarityToggle = { rarity ->
                val currentRarities = draftFilters.rarities

                draftFilters = draftFilters.copy(
                    rarities = if (rarity in currentRarities) {
                        currentRarities - rarity
                    } else {
                        currentRarities + rarity
                    }
                )
            },
            onClearFilters = {
                draftFilters = LootListFilters()
            },
            onApply = {
                onApplyFilters(draftFilters)
                onDismiss()
            }
        )
    }
}

@Composable
private fun LootListFilterContent(
    filters: LootListFilters,
    matchingCount: Int,
    onRarityToggle: (ItemRarity) -> Unit,
    onClearFilters: () -> Unit,
    onApply: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.medium),
        verticalArrangement = Arrangement.spacedBy(Dimensions.medium)
    ) {
        Text(
            text = stringResource(R.string.filter_sheet_filters),
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = stringResource(R.string.filter_sheet_rarity),
            style = MaterialTheme.typography.titleMedium
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                space = Dimensions.small
            ),
            verticalArrangement = Arrangement.spacedBy(Dimensions.extraSmall)
        ) {
            ItemRarity.entries.forEach { rarity ->
                FilterChip(
                    selected = rarity in filters.rarities,
                    onClick = { onRarityToggle(rarity) },
                    label = {
                        Text(
                            text = rarity.text(),
                            color = rarity.color
                        )
                    }
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onClearFilters) {
                Text(stringResource(R.string.filter_sheet_clear_filters))
            }

            Button(onClick = onApply) {
                Text(
                    text = stringResource(
                        R.string.filter_sheet_show_items_count,
                        matchingCount
                    )
                )
            }
        }
    }
}

@Preview(
    name = "Filters - Default",
    showBackground = true
)
@Composable
private fun LootListFilterDefaultPreview() {
    DnDLootForgeTheme {
        LootListFilterContent(
            filters = LootListFilters(),
            matchingCount = 54,
            onRarityToggle = {},
            onClearFilters = {},
            onApply = {}
        )
    }
}

@Preview(
    name = "Filters - Selected",
    showBackground = true
)
@Composable
private fun LootListFilterSelectedPreview() {
    DnDLootForgeTheme {
        LootListFilterContent(
            filters = LootListFilters(
                rarities = setOf(
                    ItemRarity.RARE,
                    ItemRarity.LEGENDARY
                )
            ),
            matchingCount = 76,
            onRarityToggle = {},
            onClearFilters = {},
            onApply = {}
        )
    }
}