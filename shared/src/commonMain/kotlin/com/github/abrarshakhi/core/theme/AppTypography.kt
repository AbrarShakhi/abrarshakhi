package com.github.abrarshakhi.core.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import abrarshakhi.shared.generated.resources.Res
import abrarshakhi.shared.generated.resources.fraunces_bold
import abrarshakhi.shared.generated.resources.fraunces_regular
import abrarshakhi.shared.generated.resources.fraunces_semibold
import abrarshakhi.shared.generated.resources.inter_bold
import abrarshakhi.shared.generated.resources.inter_medium
import abrarshakhi.shared.generated.resources.inter_regular
import abrarshakhi.shared.generated.resources.inter_semibold

object AppTypography {

    @Composable
    fun getTypography(): Typography {
        val fraunces = FontFamily(
            Font(Res.font.fraunces_regular, weight = FontWeight.Normal),
            Font(Res.font.fraunces_semibold, weight = FontWeight.SemiBold),
            Font(Res.font.fraunces_bold, weight = FontWeight.Bold)
        )

        val inter = FontFamily(
            Font(Res.font.inter_regular, weight = FontWeight.Normal),
            Font(Res.font.inter_medium, weight = FontWeight.Medium),
            Font(Res.font.inter_semibold, weight = FontWeight.SemiBold),
            Font(Res.font.inter_bold, weight = FontWeight.Bold)
        )

        return Typography(
            displayLarge = TextStyle(
                fontFamily = fraunces,
                fontWeight = FontWeight.SemiBold,
                fontSize = 56.sp,
                lineHeight = 62.sp,
                letterSpacing = (-1.2).sp
            ),
            displayMedium = TextStyle(
                fontFamily = fraunces,
                fontWeight = FontWeight.SemiBold,
                fontSize = 42.sp,
                lineHeight = 48.sp,
                letterSpacing = (-0.8).sp
            ),
            displaySmall = TextStyle(
                fontFamily = fraunces,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                lineHeight = 38.sp,
                letterSpacing = (-0.5).sp
            ),
            headlineMedium = TextStyle(
                fontFamily = fraunces,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                letterSpacing = 0.sp
            ),
            titleLarge = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 26.sp,
                letterSpacing = (-0.2).sp
            ),
            titleMedium = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                letterSpacing = 0.sp
            ),
            titleSmall = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.2.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.2.sp
            ),
            bodySmall = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.3.sp
            ),
            labelLarge = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.2.sp
            ),
            labelMedium = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp
            ),
            labelSmall = TextStyle(
                fontFamily = inter,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp
            )
        )
    }
}
