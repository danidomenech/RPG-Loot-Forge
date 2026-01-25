package com.danidomenech.dndlootforge.ui.screens.lootlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danidomenech.dndlootforge.data.model.Item
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.ui.components.ItemRow
import com.danidomenech.dndlootforge.ui.components.NAME_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.ui.components.TYPE_COLUMN_WEIGHT
import com.danidomenech.dndlootforge.ui.preview.fakeItems
import com.danidomenech.dndlootforge.ui.theme.DnDLootForgeTheme

@ExperimentalMaterial3Api
@Composable
fun LootListScreen(
    viewModel: LootListViewModel = hiltViewModel(),
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {
    val items by viewModel.items.collectAsState()
    LootListContent(items = items, onItemClick = onItemClick)
}

@ExperimentalMaterial3Api
@Composable
fun LootListContent(
    items: List<Item>,
    onItemClick: (Item, priceModifierPercent: Int?) -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.all_items_screen_title)) })
        }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

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
                    modifier = Modifier.weight(TYPE_COLUMN_WEIGHT),
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                itemsIndexed(
                    items = items,
                    key = { _, item -> item.id }
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


//PREVIEWS
@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun LootListScreenPreview() {

    val fakeItems = fakeItems

    DnDLootForgeTheme {
        LootListContent(
            items = fakeItems,
            onItemClick = { _, _ -> }
        )
    }
}