package com.danidomenech.dndlootforge.feature.itemdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.components.VerticalScrollbar
import com.danidomenech.dndlootforge.core.design.item.color
import com.danidomenech.dndlootforge.core.design.item.text
import com.danidomenech.dndlootforge.core.design.theme.Dimensions
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.model.ItemOrigin
import com.danidomenech.dndlootforge.core.design.theme.ItemOriginEditedColor
import com.danidomenech.dndlootforge.core.design.theme.DnDLootForgeTheme
import com.danidomenech.dndlootforge.preview.fakeItems

@Composable
fun ItemDetailSheetContent(
    item: Item,
    priceModifierPercent: Int? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimensions.large,
                vertical = Dimensions.medium
            )
    ) {
        ItemDetailTitle(item = item)

        ItemDetailMetadataRow(item = item)

        ItemDetailBody(
            item = item,
            priceModifierPercent = priceModifierPercent
        )
    }
}

@Composable
private fun ItemDetailTitle(
    item: Item
) {
    Text(
        text = stringResource(item.nameResId).uppercase(),
        color = item.rarity.color,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dimensions.small)
    )
}

@Composable
private fun ItemDetailMetadataRow(
    item: Item
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dimensions.medium),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${item.type.text()}, ${item.rarity.text()}",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.wrapContentSize()
        )

        ItemOriginIcon(origin = item.origin)
    }
}

@Composable
private fun ItemOriginIcon(
    origin: ItemOrigin
) {
    val (icon, iconTint) = when (origin) {
        ItemOrigin.BOOK -> Icons.AutoMirrored.Filled.MenuBook to MaterialTheme.colorScheme.onSurfaceVariant
        ItemOrigin.BOOK_EDITED -> Icons.AutoMirrored.Filled.MenuBook to ItemOriginEditedColor
        ItemOrigin.BG3 -> Icons.Filled.VideogameAsset to MaterialTheme.colorScheme.onSurfaceVariant
        ItemOrigin.BG3_EDITED -> Icons.Filled.VideogameAsset to ItemOriginEditedColor
        ItemOrigin.HOMEBREW -> Icons.Filled.Lightbulb to MaterialTheme.colorScheme.onSurfaceVariant
    }

    Icon(
        imageVector = icon,
        contentDescription = origin.name,
        tint = iconTint
    )
}

@Composable
private fun ItemDetailBody(
    item: Item,
    priceModifierPercent: Int?
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = MaxDescriptionHeight)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(end = Dimensions.medium)
        ) {
            if (item.requiresAttunement) {
                Text(
                    text = stringResource(R.string.requires_attunement),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(bottom = Dimensions.medium)
                )
            }

            Text(
                text = stringResource(item.descriptionResId),
                style = MaterialTheme.typography.bodyMedium
            )

            item.descriptionExtraResId?.let { descriptionExtraResId ->
                Text(
                    text = stringResource(descriptionExtraResId),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.padding(top = Dimensions.medium)
                )
            }

            val finalPrice = item.getFinalPrice(priceModifierPercent)

            Text(
                text = stringResource(R.string.item_value, finalPrice),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = Dimensions.medium)
            )
        }

        VerticalScrollbar(
            scrollState = scrollState,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .matchParentSize()
        )
    }
}

private fun Item.getFinalPrice(
    priceModifierPercent: Int?
): Int {
    return priceModifierPercent?.let { modifier ->
        (value * (1 + modifier / 100f)).toInt().coerceAtLeast(0)
    } ?: value
}

private val MaxDescriptionHeight = 600.dp

@Preview(showBackground = true)
@Composable
private fun ItemDetailSheetContentPreview() {
    DnDLootForgeTheme {
        ItemDetailSheetContent(
            item = fakeItems.first()
        )
    }
}