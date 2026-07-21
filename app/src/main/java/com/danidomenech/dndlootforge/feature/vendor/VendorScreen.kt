package com.danidomenech.dndlootforge.feature.vendor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.components.ItemRow
import com.danidomenech.dndlootforge.core.design.components.NAME_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.TYPE_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.VerticalScrollbar
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.preview.fakeItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendorScreen(
    uiState: VendorUiState,
    onAction: (VendorAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.vendor_screen_title))
                }
            )
        }
    ) { paddingValues ->
        VendorListContent(
            items = uiState.items,
            playerLevel = uiState.playerLevel,
            onPlayerLevelChange = { playerLevel ->
                onAction(VendorAction.PlayerLevelChange(playerLevel))
            },
            onItemClick = { item ->
                onAction(VendorAction.ItemClick(item))
            },
            onGenerateCatalogClick = {
                onAction(VendorAction.GenerateCatalogClick(uiState.playerLevel))
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun VendorListContent(
    items: List<Item>,
    playerLevel: Int,
    onPlayerLevelChange: (Int) -> Unit,
    onItemClick: (Item) -> Unit,
    onGenerateCatalogClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        VendorPlayerLevelSlider(
            playerLevel = playerLevel,
            onPlayerLevelChange = onPlayerLevelChange
        )

        Spacer(Modifier.height(Dimensions.small))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = onGenerateCatalogClick) {
                Text(stringResource(R.string.generate_random_catalog))
            }
        }

        Spacer(Modifier.height(Dimensions.small))

        VendorColumnHeaders()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(Dimensions.small),
                verticalArrangement = Arrangement.spacedBy(Dimensions.extraSmall)
            ) {
                itemsIndexed(
                    items = items,
                    key = { _, item -> item.id.value }
                ) { index, item ->
                    ItemRow(
                        item = item,
                        index = index,
                        onClick = { onItemClick(item) }
                    )
                }
            }

            VerticalScrollbar(
                listState = listState,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .matchParentSize()
            )
        }
    }
}

@Composable
private fun VendorPlayerLevelSlider(
    playerLevel: Int,
    onPlayerLevelChange: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimensions.medium,
                vertical = Dimensions.small
            )
    ) {
        Text(
            text = stringResource(R.string.player_level, playerLevel),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = Dimensions.extraSmall)
        )

        Slider(
            value = playerLevel.toFloat(),
            onValueChange = { value ->
                onPlayerLevelChange(value.toInt())
            },
            valueRange = MIN_PLAYER_LEVEL_FLOAT..MAX_PLAYER_LEVEL_FLOAT,
            steps = PLAYER_LEVEL_STEPS,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimensions.small)
        )
    }
}

@Composable
private fun VendorColumnHeaders() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimensions.medium,
                vertical = Dimensions.small
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.magic_item),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.weight(NAME_COLUMN_WEIGHT)
        )

        Text(
            text = stringResource(R.string.type),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VendorScreenPreview() {
    DnDLootForgeTheme {
        VendorScreen(
            uiState = VendorUiState(
                items = fakeItems,
                playerLevel = 2
            ),
            onAction = {}
        )
    }
}

private const val MIN_PLAYER_LEVEL_FLOAT = 1f
private const val MAX_PLAYER_LEVEL_FLOAT = 20f
private const val PLAYER_LEVEL_STEPS = 18