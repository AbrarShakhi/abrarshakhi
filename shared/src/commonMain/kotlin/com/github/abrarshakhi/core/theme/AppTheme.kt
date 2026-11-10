package com.github.abrarshakhi.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalThemeIsDark = staticCompositionLocalOf { false }

@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        AppColors.createDarkColorScheme()
    } else {
        AppColors.createLightColorScheme()
    }

    val shapes = Shapes(
        extraSmall = AppShapes.extraSmall,
        small = AppShapes.small,
        medium = AppShapes.medium,
        large = AppShapes.large,
        extraLarge = AppShapes.extraLarge
    )

    val typography = AppTypography.getTypography()

    CompositionLocalProvider(
        LocalThemeIsDark provides darkTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}
