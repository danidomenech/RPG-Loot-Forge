package com.danidomenech.dndlootforge.core.design.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.core.design.theme.RarityCommon
import com.danidomenech.dndlootforge.core.design.theme.RarityLegendary
import com.danidomenech.dndlootforge.core.design.theme.RarityRare
import com.danidomenech.dndlootforge.core.design.theme.RarityUncommon
import com.danidomenech.dndlootforge.core.design.theme.RarityVeryRare
import com.danidomenech.dndlootforge.domain.model.ItemRarity

val ItemRarity.color: Color
    get() = when (this) {
        ItemRarity.COMMON -> RarityCommon
        ItemRarity.UNCOMMON -> RarityUncommon
        ItemRarity.RARE -> RarityRare
        ItemRarity.VERY_RARE -> RarityVeryRare
        ItemRarity.LEGENDARY -> RarityLegendary
    }

@Composable
fun ItemRarity.text(): String {
    return stringResource(
        when (this) {
            ItemRarity.COMMON -> R.string.item_rarity_common
            ItemRarity.UNCOMMON -> R.string.item_rarity_uncommon
            ItemRarity.RARE -> R.string.item_rarity_rare
            ItemRarity.VERY_RARE -> R.string.item_rarity_very_rare
            ItemRarity.LEGENDARY -> R.string.item_rarity_legendary
        }
    )
}