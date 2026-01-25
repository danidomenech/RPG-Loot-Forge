package com.danidomenech.dndlootforge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.ui.preview.fakeItems
import com.danidomenech.dndlootforge.ui.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.ui.theme.UnevenRow
import com.danidomenech.dndlootforge.ui.utils.TextHelper

const val NAME_COLUMN_WEIGHT = 2f
const val TYPE_COLUMN_WEIGHT = 1f

@Composable
fun ItemRow(
    item: Item,
    index: Int,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val backgroundColor = if (index % 2 == 0) UnevenRow else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = context.getString(item.nameResId),
            color = TextHelper.getRarityColor(item.rarity),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(NAME_COLUMN_WEIGHT)
                .padding(end = 8.dp)
        )

        Text(
            text = TextHelper.getItemTypeString(item.type),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(TYPE_COLUMN_WEIGHT),
        )
    }
}

//PREVIEWS
@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun LootListScreenPreview() {

    val fakeItems = fakeItems

    DnDLootForgeTheme {
        ItemRow(fakeItems[0],0, onClick = {})
    }
}