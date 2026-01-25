package com.danidomenech.dndlootforge.ui.screens.itemdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.data.model.ItemOrigin
import com.danidomenech.dndlootforge.data.model.ItemRarity
import com.danidomenech.dndlootforge.data.model.ItemType
import com.danidomenech.dndlootforge.ui.theme.ItemOriginEditedColor
import com.danidomenech.dndlootforge.ui.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.ui.utils.TextHelper

@Composable
fun ItemDetailSheetContent(
    item: Item,
    priceModifierPercent: Int? = null
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        // Title
        Text(
            text = context.getString(item.nameResId).uppercase(),
            color = TextHelper.getRarityColor(item.rarity),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Type and Rarity
            Text(
                text = "${TextHelper.getItemTypeString(item.type)}, ${TextHelper.getRarityTextString(item.rarity)}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier
                    .wrapContentSize()
            )

            val (icon, iconTint) = when (item.origin) {
                ItemOrigin.BOOK -> Icons.AutoMirrored.Filled.MenuBook to MaterialTheme.colorScheme.onSurfaceVariant
                ItemOrigin.BOOK_EDITED -> Icons.AutoMirrored.Filled.MenuBook to ItemOriginEditedColor
                ItemOrigin.BG3 -> Icons.Filled.VideogameAsset to MaterialTheme.colorScheme.onSurfaceVariant
                ItemOrigin.BG3_EDITED -> Icons.Filled.VideogameAsset to ItemOriginEditedColor
                ItemOrigin.HOMEBREW -> Icons.Filled.Lightbulb to MaterialTheme.colorScheme.onSurfaceVariant
            }

            Icon(
                imageVector = icon,
                contentDescription = item.origin.name,
                tint = iconTint
            )
        }

        // Scrollable content from this point on
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 600.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 0.dp)
        ) {
            // Requires attunement
            if (item.requiresAttunement) {
                Text(
                    text = stringResource(R.string.requires_attunement),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            // Description
            Text(
                text = context.getString(item.descriptionResId),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 0.dp)
            )

            // Description Extra
            item.descriptionExtraResId?.let {
                Text(
                    text = context.getString(it),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            // Value
            val finalPrice = priceModifierPercent?.let {
                (item.value * (1 + it / 100f)).toInt().coerceAtLeast(0)
            } ?: item.value

            Text(
                text = stringResource(R.string.item_value, finalPrice),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailSheetContentPreview() {
    DnDLootForgeTheme {
        val fakeItem = Item(
            id = "healing_potion",
            nameResId = R.string.healing_potion,
            type = ItemType.POTION,
            rarity = ItemRarity.COMMON,
            descriptionResId = R.string.healing_potion_description,
            descriptionExtraResId = R.string.healing_potion_description_extra,
            value = 50,
            powerLevel = 50,
            requiresAttunement = true
        )

        ItemDetailSheetContent(item = fakeItem)
    }
}