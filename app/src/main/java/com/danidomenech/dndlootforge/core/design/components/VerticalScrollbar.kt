package com.danidomenech.dndlootforge.core.design.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun VerticalScrollbar(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    thumbWidth: Dp = ScrollbarDefaults.ThumbWidth,
    minThumbHeight: Dp = ScrollbarDefaults.MinThumbHeight,
    paddingEnd: Dp = ScrollbarDefaults.PaddingEnd,
    shape: Shape = RoundedCornerShape(percent = 50),
    thumbColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = ScrollbarDefaults.THUMB_ALPHA),
    autoHide: Boolean = true
) {
    val layoutInfo = listState.layoutInfo
    val totalItemsCount = layoutInfo.totalItemsCount
    val visibleItems = layoutInfo.visibleItemsInfo

    val isVisible = !autoHide || listState.isScrollInProgress

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = ScrollbarDefaults.AUTO_HIDE_DURATION_MILIS),
        label = "VerticalScrollbarAlpha"
    )

    if (totalItemsCount == 0 || visibleItems.isEmpty()) return

    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
            .padding(end = paddingEnd),
        contentAlignment = Alignment.TopEnd
    ) {
        val viewportHeightPx = constraints.maxHeight.toFloat()
        if (viewportHeightPx <= 0f) return@BoxWithConstraints

        val firstVisibleItem = visibleItems.first()
        val averageItemHeightPx = visibleItems
            .map { it.size }
            .average()
            .toFloat()
            .coerceAtLeast(1f)

        val totalContentHeightPx = averageItemHeightPx * totalItemsCount
        val viewportFraction = (viewportHeightPx / totalContentHeightPx)
            .coerceIn(0f, 1f)

        val thumbHeightPx = (viewportHeightPx * viewportFraction).coerceAtLeast(
            with(LocalDensity.current) { minThumbHeight.toPx() }
        )

        val firstVisibleItemScrollOffsetPx =
            firstVisibleItem.index * averageItemHeightPx + listState.firstVisibleItemScrollOffset

        val maxScrollOffsetPx = (totalContentHeightPx - viewportHeightPx).coerceAtLeast(1f)
        val scrollProgress = (firstVisibleItemScrollOffsetPx / maxScrollOffsetPx)
            .coerceIn(0f, 1f)

        val maxThumbOffsetPx = viewportHeightPx - thumbHeightPx
        val thumbOffsetPx = scrollProgress * maxThumbOffsetPx

        Box(
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = 0,
                        y = thumbOffsetPx.roundToInt()
                    )
                }
                .width(thumbWidth)
                .height(with(LocalDensity.current) { thumbHeightPx.toDp() })
                .alpha(alpha)
                .background(
                    color = thumbColor,
                    shape = shape
                )
        )
    }
}

private object ScrollbarDefaults {
    const val AUTO_HIDE_DURATION_MILIS = 1000
    const val THUMB_ALPHA = 0.65f

    val ThumbWidth = 3.dp
    val MinThumbHeight = 24.dp
    val PaddingEnd = 2.dp
}