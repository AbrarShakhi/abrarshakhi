package com.github.abrarshakhi.core.responsive

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.github.abrarshakhi.core.theme.AppSpacing

object ResponsiveLayout {
    @Composable
    fun current(): WindowDimensions = LocalWindowDimensions.current

    @Composable
    fun pageGutter(): Dp {
        val window = LocalWindowDimensions.current
        return when (window.widthSizeClass) {
            WindowWidthSizeClass.COMPACT -> AppSpacing.pageGutterMobile
            WindowWidthSizeClass.MEDIUM -> AppSpacing.pageGutterTablet
            WindowWidthSizeClass.EXPANDED -> AppSpacing.pageGutterDesktop
        }
    }

    @Composable
    fun sectionGap(): Dp {
        val window = LocalWindowDimensions.current
        return when (window.widthSizeClass) {
            WindowWidthSizeClass.COMPACT -> AppSpacing.sectionGapMobile
            WindowWidthSizeClass.MEDIUM -> AppSpacing.sectionGapTablet
            WindowWidthSizeClass.EXPANDED -> AppSpacing.sectionGapDesktop
        }
    }

    @Composable
    fun projectGridColumns(): Int {
        val window = LocalWindowDimensions.current
        return when (window.widthSizeClass) {
            WindowWidthSizeClass.COMPACT -> 1
            WindowWidthSizeClass.MEDIUM -> 2
            WindowWidthSizeClass.EXPANDED -> if (window.width > 1200.DpWrapper) 2 else 2
        }
    }
}

private val Int.DpWrapper: Dp get() = Dp(this.toFloat())
