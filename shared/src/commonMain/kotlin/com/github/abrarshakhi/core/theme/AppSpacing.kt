package com.github.abrarshakhi.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object AppSpacing {
    val xs: Dp = 4.dp
    val sm: Dp = 8.dp
    val md: Dp = 16.dp
    val lg: Dp = 24.dp
    val xl: Dp = 32.dp
    val xxl: Dp = 48.dp
    val xxxl: Dp = 80.dp

    val maxContentWidth: Dp = 1120.dp
    val maxNarrowContentWidth: Dp = 760.dp

    val sectionGapDesktop: Dp = 96.dp
    val sectionGapTablet: Dp = 72.dp
    val sectionGapMobile: Dp = 56.dp

    val pageGutterDesktop: Dp = 48.dp
    val pageGutterTablet: Dp = 32.dp
    val pageGutterMobile: Dp = 20.dp

    val topNavHeight: Dp = 68.dp
}

object AppShapes {
    val extraSmall = RoundedCornerShape(8.dp)
    val small = RoundedCornerShape(12.dp)
    val medium = RoundedCornerShape(16.dp)
    val large = RoundedCornerShape(24.dp)
    val extraLarge = RoundedCornerShape(32.dp)
    val pill = RoundedCornerShape(100.dp)
}
