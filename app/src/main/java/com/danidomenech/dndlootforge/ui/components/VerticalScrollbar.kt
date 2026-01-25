package com.danidomenech.dndlootforge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun VerticalScrollbar(
    listSize: Int,
    firstVisibleIndex: Int,
    visibleItemCount: Int,
    visibleHeightPx: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    thickness: Dp = 4.dp
) {
    val totalItems = listSize.coerceAtLeast(1)
    val visibleItems = visibleItemCount.coerceAtLeast(1)
    val scrollbarHeight = (visibleHeightPx.toFloat() * visibleItems / totalItems).coerceAtLeast(20f)
    val scrollbarOffset = (visibleHeightPx.toFloat() * firstVisibleIndex / totalItems)

    Box(
        modifier = modifier
            .height(with(LocalDensity.current) { visibleHeightPx.toDp() }) // 👈 limit the height
            .width(thickness)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .offset { IntOffset(0, scrollbarOffset.roundToInt()) }
                .width(thickness)
                .height(scrollbarHeight.dp)
                .background(color, shape = RoundedCornerShape(2.dp))
        )
    }
}