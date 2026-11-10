package com.github.abrarshakhi.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.github.abrarshakhi.core.responsive.ResponsiveLayout
import com.github.abrarshakhi.core.theme.AppSpacing

@Composable
fun SectionContainer(
    modifier: Modifier = Modifier,
    maxWidth: Dp = AppSpacing.maxContentWidth,
    topGap: Boolean = true,
    content: @Composable () -> Unit
) {
    val gutter = ResponsiveLayout.pageGutter()
    val gap = if (topGap) ResponsiveLayout.sectionGap() else AppSpacing.xs

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = gutter)
            .padding(top = gap),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = maxWidth),
            contentAlignment = Alignment.TopStart
        ) {
            content()
        }
    }
}
