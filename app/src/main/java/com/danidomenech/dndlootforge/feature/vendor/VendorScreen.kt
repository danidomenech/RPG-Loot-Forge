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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.components.ItemRow
import com.danidomenech.dndlootforge.core.design.components.NAME_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.core.design.components.TYPE_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.core.navigation.AppDestination
import com.danidomenech.dndlootforge.preview.fakeItems
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme

@Composable
fun VendorScreen(
    viewModel: VendorViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit,
    onGenerateCatalogClick: () -> Unit
) {
    val items by viewModel.vendorItems.collectAsState()
    val playerLevel by viewModel.playerLevel.collectAsState()

    VendorListContent(
        items = items,
        playerLevel = playerLevel,
        onPlayerLevelChange = viewModel::setPlayerLevel,
        onItemClick = onItemClick,
        onGenerateCatalogClick = onGenerateCatalogClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendorListContent(
    items: List<Item>,
    playerLevel: Int? = null,
    onPlayerLevelChange: ((Int) -> Unit)? = null,
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit,
    onGenerateCatalogClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.vendor_screen_title)) }
            )
        }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

            if (playerLevel != null && onPlayerLevelChange != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.player_level, playerLevel),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Slider(
                        value = playerLevel.toFloat(),
                        onValueChange = { onPlayerLevelChange(it.toInt()) },
                        valueRange = 1f..20f,
                        steps = 18,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = onGenerateCatalogClick) {
                    Text(stringResource(R.string.generate_random_catalog))
                }
            }

            Spacer(Modifier.height(8.dp))

            // Column headers
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
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

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                itemsIndexed(
                    items = items,
                    key = { _, item -> item.id.value }
                ) { index, item ->
                    ItemRow(
                        item = item,
                        index = index,
                        onClick = { onItemClick(item, null) }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun VendorScreenPreview() {
    DnDLootForgeTheme {
        VendorListContent(
            items = fakeItems,
            onItemClick = { _, _ -> },
            playerLevel = 2,
            onPlayerLevelChange = {},
            onGenerateCatalogClick = {}
        )
    }
}