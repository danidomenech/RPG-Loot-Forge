package com.danidomenech.dndlootforge.ui.utils

import android.content.Context
import android.graphics.Typeface
import android.text.Html
import android.text.Spanned
import android.text.TextUtils
import android.text.style.StyleSpan
import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.danidomenech.dndlootforge.R
import com.danidomenech.dndlootforge.data.model.ItemRarity
import com.danidomenech.dndlootforge.data.model.ItemType
import com.danidomenech.dndlootforge.ui.theme.RarityCommon
import com.danidomenech.dndlootforge.ui.theme.RarityLegendary
import com.danidomenech.dndlootforge.ui.theme.RarityRare
import com.danidomenech.dndlootforge.ui.theme.RarityUncommon
import com.danidomenech.dndlootforge.ui.theme.RarityVeryRare

object TextHelper {

    fun getRarityColor(rarity: ItemRarity): Color {
        return when (rarity) {
            ItemRarity.COMMON -> RarityCommon
            ItemRarity.UNCOMMON -> RarityUncommon
            ItemRarity.RARE -> RarityRare
            ItemRarity.VERY_RARE -> RarityVeryRare
            ItemRarity.LEGENDARY -> RarityLegendary
        }
    }

    @Composable
    fun getRarityTextString(rarity: ItemRarity): String {
        return when (rarity) {
            ItemRarity.COMMON -> stringResource(R.string.item_rarity_common)
            ItemRarity.UNCOMMON -> stringResource(R.string.item_rarity_uncommon)
            ItemRarity.RARE -> stringResource(R.string.item_rarity_rare)
            ItemRarity.VERY_RARE -> stringResource(R.string.item_rarity_very_rare)
            ItemRarity.LEGENDARY -> stringResource(R.string.item_rarity_legendary)
        }
    }

    @Composable
    fun getItemTypeString(type: ItemType): String {
        return when (type) {
            ItemType.WEAPON -> stringResource(R.string.item_type_weapon)
            ItemType.JAVELIN -> stringResource(R.string.item_type_javelin)
            ItemType.DAGGER -> stringResource(R.string.item_type_dagger)
            ItemType.SHORT_SWORD -> stringResource(R.string.item_type_short_sword)
            ItemType.LONG_SWORD -> stringResource(R.string.item_type_long_sword)
            ItemType.GREATSWORD -> stringResource(R.string.item_type_greatsword)
            ItemType.HAND_AXE -> stringResource(R.string.item_type_hand_axe)
            ItemType.BATTLE_AXE -> stringResource(R.string.item_type_battle_axe)
            ItemType.GREATAXE -> stringResource(R.string.item_type_greataxe)
            ItemType.WARHAMMER -> stringResource(R.string.item_type_warhammer)
            ItemType.MAUL -> stringResource(R.string.item_type_maul)
            ItemType.SHORT_BOW -> stringResource(R.string.item_type_short_bow)
            ItemType.LONG_BOW -> stringResource(R.string.item_type_long_bow)
            ItemType.HAND_CROSSBOW -> stringResource(R.string.item_type_hand_crossbow)
            ItemType.LIGHT_CROSSBOW -> stringResource(R.string.item_type_light_crossbow)
            ItemType.HEAVY_CROSSBOW -> stringResource(R.string.item_type_heavy_crossbow)
            ItemType.TRIDENT -> stringResource(R.string.item_type_trident)
            ItemType.STAFF -> stringResource(R.string.item_type_staff)
            ItemType.ROD -> stringResource(R.string.item_type_rod)
            ItemType.ARMOR -> stringResource(R.string.item_type_armor)
            ItemType.CLOTHING -> stringResource(R.string.item_type_clothing)
            ItemType.LIGHT_ARMOR -> stringResource(R.string.item_type_light_armor)
            ItemType.MEDIUM_ARMOR -> stringResource(R.string.item_type_medium_armor)
            ItemType.HEAVY_ARMOR -> stringResource(R.string.item_type_heavy_armor)
            ItemType.SHIELD -> stringResource(R.string.item_type_shield)
            ItemType.ACCESSORY -> stringResource(R.string.item_type_accessory)
            ItemType.HELMET -> stringResource(R.string.item_type_helmet)
            ItemType.GLOVES -> stringResource(R.string.item_type_gloves)
            ItemType.BOOTS -> stringResource(R.string.item_type_boots)
            ItemType.NECKLACE -> stringResource(R.string.item_type_necklace)
            ItemType.CLOAK -> stringResource(R.string.item_type_cloak)
            ItemType.RING -> stringResource(R.string.item_type_ring)
            ItemType.WAND -> stringResource(R.string.item_type_wand)
            ItemType.POTION -> stringResource(R.string.item_type_potion)
            ItemType.CONSUMABLE -> stringResource(R.string.item_type_consumable)
            ItemType.AMMUNITION -> stringResource(R.string.item_type_ammunition)
            ItemType.SCROLL -> stringResource(R.string.item_type_scroll)
            ItemType.MAGICAL_TOOL -> stringResource(R.string.item_type_magical_tool)
            ItemType.MISC -> stringResource(R.string.item_type_misc)
        }
    }

    @Composable
    fun getLootTablePlayerLevel(playerLevels: IntRange?): String {
        return if (playerLevels?.first == playerLevels?.last) {
            "${playerLevels?.first}"
        } else {
            "${playerLevels?.first}-${playerLevels?.last}"
        }
    }

    @Composable
    fun HtmlResText(
        @StringRes resId: Int,
        modifier: Modifier = Modifier,
        style: TextStyle = MaterialTheme.typography.bodyMedium
    ) {
        val context = LocalContext.current
        val annotatedText = remember(resId) {
            getHtmlText(context, resId).toAnnotatedString()
        }

        Text(
            text = annotatedText,
            style = style,
            modifier = modifier
        )
    }

    private fun getHtmlText(context: Context, @StringRes resId: Int): Spanned {
        val rawString = context.getString(resId)
        return Html.fromHtml(rawString, Html.FROM_HTML_MODE_LEGACY)
    }

    private fun Spanned.toAnnotatedString(): AnnotatedString {
        val builder = AnnotatedString.Builder()

        var index = 0
        while (index < this.length) {
            val next = TextUtils.indexOf(this, ' ', index).let {
                if (it == -1) this.length else it
            }

            val spanStyles = this.getSpans(index, next, Any::class.java)
            val style = when {
                spanStyles.any { it is StyleSpan && it.style == Typeface.ITALIC } -> SpanStyle(fontStyle = FontStyle.Italic)
                spanStyles.any { it is StyleSpan && it.style == Typeface.BOLD } -> SpanStyle(fontWeight = FontWeight.Bold)
                else -> null
            }

            val word = this.subSequence(index, next).toString()
            builder.withStyle(style ?: SpanStyle()) {
                append(word)
            }

            // Add space if not at end
            if (next < this.length) builder.append(" ")

            index = next + 1
        }

        return builder.toAnnotatedString()
    }
}