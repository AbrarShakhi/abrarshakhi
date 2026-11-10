package com.github.abrarshakhi.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.theme.AppShapes
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.core.util.openUrl
import com.github.abrarshakhi.domain.model.SocialIconType
import com.github.abrarshakhi.domain.model.SocialLink

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SocialRow(
    socials: List<SocialLink>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(AppSpacing.sm),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(AppSpacing.sm)
    ) {
        for (social in socials) {
            SocialButton(social = social)
        }
    }
}

@Composable
fun SocialButton(
    social: SocialLink,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val containerColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceContainerLow
        },
        animationSpec = tween(durationMillis = 180)
    )

    val iconColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        animationSpec = tween(durationMillis = 180)
    )

    val borderColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        } else {
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)
        },
        animationSpec = tween(durationMillis = 180)
    )

    val icon = when (social.iconType) {
        SocialIconType.GITHUB -> AppIcons.Code
        SocialIconType.EMAIL -> AppIcons.Mail
        SocialIconType.LINKEDIN -> AppIcons.Work
        SocialIconType.GENERIC -> AppIcons.ExternalLink
    }

    OutlinedButton(
        onClick = { openUrl(social.url) },
        modifier = modifier.size(46.dp),
        interactionSource = interactionSource,
        shape = AppShapes.small,
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = iconColor
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = social.label,
            modifier = Modifier.size(20.dp),
            tint = iconColor
        )
    }
}
