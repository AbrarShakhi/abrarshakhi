package com.github.abrarshakhi.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object AppColors {
    // Primary Brand - Expressive Indigo / Vibrant Blue
    val PrimaryLight = Color(0xFF2752D8)
    val OnPrimaryLight = Color(0xFFFFFFFF)
    val PrimaryContainerLight = Color(0xFFDEE1FF)
    val OnPrimaryContainerLight = Color(0xFF001257)

    val PrimaryDark = Color(0xFFB9C3FF)
    val OnPrimaryDark = Color(0xFF002387)
    val PrimaryContainerDark = Color(0xFF0437BC)
    val OnPrimaryContainerDark = Color(0xFFDEE1FF)

    // Secondary - Expressive Cyan / Teal
    val SecondaryLight = Color(0xFF00677D)
    val OnSecondaryLight = Color(0xFFFFFFFF)
    val SecondaryContainerLight = Color(0xFFB4EBFF)
    val OnSecondaryContainerLight = Color(0xFF001F27)

    val SecondaryDark = Color(0xFF5DD4FC)
    val OnSecondaryDark = Color(0xFF003542)
    val SecondaryContainerDark = Color(0xFF004E5F)
    val OnSecondaryContainerDark = Color(0xFFB4EBFF)

    // Tertiary - Warm Terracotta / Coral Accent
    val TertiaryLight = Color(0xFF984724)
    val OnTertiaryLight = Color(0xFFFFFFFF)
    val TertiaryContainerLight = Color(0xFFFFDBCF)
    val OnTertiaryContainerLight = Color(0xFF380D00)

    val TertiaryDark = Color(0xFFFFB59B)
    val OnTertiaryDark = Color(0xFF5B1B00)
    val TertiaryContainerDark = Color(0xFF7A3010)
    val OnTertiaryContainerDark = Color(0xFFFFDBCF)

    // Surfaces - Light Mode (Clean, subtle warmth)
    val BackgroundLight = Color(0xFFF9F9FC)
    val OnBackgroundLight = Color(0xFF191C20)
    val SurfaceLight = Color(0xFFFCFCFF)
    val OnSurfaceLight = Color(0xFF191C20)
    val SurfaceVariantLight = Color(0xFFE2E2EC)
    val OnSurfaceVariantLight = Color(0xFF45464F)
    val SurfaceContainerLowestLight = Color(0xFFFFFFFF)
    val SurfaceContainerLowLight = Color(0xFFF3F3F7)
    val SurfaceContainerLight = Color(0xFFEDEDF2)
    val SurfaceContainerHighLight = Color(0xFFE7E8EC)
    val SurfaceContainerHighestLight = Color(0xFFE2E2E7)
    val OutlineLight = Color(0xFF757680)
    val OutlineVariantLight = Color(0xFFC5C6D0)

    // Surfaces - Dark Mode (Rich OLED dark, vibrant depth)
    val BackgroundDark = Color(0xFF111318)
    val OnBackgroundDark = Color(0xFFE2E2E7)
    val SurfaceDark = Color(0xFF111318)
    val OnSurfaceDark = Color(0xFFE2E2E7)
    val SurfaceVariantDark = Color(0xFF45464F)
    val OnSurfaceVariantDark = Color(0xFFC5C6D0)
    val SurfaceContainerLowestDark = Color(0xFF0C0E12)
    val SurfaceContainerLowDark = Color(0xFF191C20)
    val SurfaceContainerDark = Color(0xFF1E2024)
    val SurfaceContainerHighDark = Color(0xFF282A2F)
    val SurfaceContainerHighestDark = Color(0xFF33353A)
    val OutlineDark = Color(0xFF8F909A)
    val OutlineVariantDark = Color(0xFF45464F)

    // Custom Status & Accent Colors
    val AvailableGreen = Color(0xFF22C55E)
    val AvailableGreenContainer = Color(0xFF14532D)
    val ChipBackgroundLight = Color(0xFFEEF0F8)
    val ChipBackgroundDark = Color(0xFF262830)

    fun createLightColorScheme(): ColorScheme = lightColorScheme(
        primary = PrimaryLight,
        onPrimary = OnPrimaryLight,
        primaryContainer = PrimaryContainerLight,
        onPrimaryContainer = OnPrimaryContainerLight,
        secondary = SecondaryLight,
        onSecondary = OnSecondaryLight,
        secondaryContainer = SecondaryContainerLight,
        onSecondaryContainer = OnSecondaryContainerLight,
        tertiary = TertiaryLight,
        onTertiary = OnTertiaryLight,
        tertiaryContainer = TertiaryContainerLight,
        onTertiaryContainer = OnTertiaryContainerLight,
        background = BackgroundLight,
        onBackground = OnBackgroundLight,
        surface = SurfaceLight,
        onSurface = OnSurfaceLight,
        surfaceVariant = SurfaceVariantLight,
        onSurfaceVariant = OnSurfaceVariantLight,
        outline = OutlineLight,
        outlineVariant = OutlineVariantLight,
        surfaceContainerLowest = SurfaceContainerLowestLight,
        surfaceContainerLow = SurfaceContainerLowLight,
        surfaceContainer = SurfaceContainerLight,
        surfaceContainerHigh = SurfaceContainerHighLight,
        surfaceContainerHighest = SurfaceContainerHighestLight
    )

    fun createDarkColorScheme(): ColorScheme = darkColorScheme(
        primary = PrimaryDark,
        onPrimary = OnPrimaryDark,
        primaryContainer = PrimaryContainerDark,
        onPrimaryContainer = OnPrimaryContainerDark,
        secondary = SecondaryDark,
        onSecondary = OnSecondaryDark,
        secondaryContainer = SecondaryContainerDark,
        onSecondaryContainer = OnSecondaryContainerDark,
        tertiary = TertiaryDark,
        onTertiary = OnTertiaryDark,
        tertiaryContainer = TertiaryContainerDark,
        onTertiaryContainer = OnTertiaryContainerDark,
        background = BackgroundDark,
        onBackground = OnBackgroundDark,
        surface = SurfaceDark,
        onSurface = OnSurfaceDark,
        surfaceVariant = SurfaceVariantDark,
        onSurfaceVariant = OnSurfaceVariantDark,
        outline = OutlineDark,
        outlineVariant = OutlineVariantDark,
        surfaceContainerLowest = SurfaceContainerLowestDark,
        surfaceContainerLow = SurfaceContainerLowDark,
        surfaceContainer = SurfaceContainerDark,
        surfaceContainerHigh = SurfaceContainerHighDark,
        surfaceContainerHighest = SurfaceContainerHighestDark
    )
}
