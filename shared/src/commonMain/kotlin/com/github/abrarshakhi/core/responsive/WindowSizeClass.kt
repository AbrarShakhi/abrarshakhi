package com.github.abrarshakhi.core.responsive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowWidthSizeClass {
    COMPACT,   // < 600dp (Mobile phones)
    MEDIUM,    // 600dp - 840dp (Tablets, foldables)
    EXPANDED   // > 840dp (Laptops, Desktops, Ultrawide)
}

data class WindowDimensions(
    val width: Dp,
    val height: Dp,
    val widthSizeClass: WindowWidthSizeClass = calculateWidthSizeClass(width)
) {
    val isCompact: Boolean get() = widthSizeClass == WindowWidthSizeClass.COMPACT
    val isMedium: Boolean get() = widthSizeClass == WindowWidthSizeClass.MEDIUM
    val isExpanded: Boolean get() = widthSizeClass == WindowWidthSizeClass.EXPANDED

    companion object {
        fun calculateWidthSizeClass(width: Dp): WindowWidthSizeClass = when {
            width < 600.dp -> WindowWidthSizeClass.COMPACT
            width < 840.dp -> WindowWidthSizeClass.MEDIUM
            else -> WindowWidthSizeClass.EXPANDED
        }
    }
}

val LocalWindowDimensions = compositionLocalOf {
    WindowDimensions(width = 1200.dp, height = 800.dp)
}
