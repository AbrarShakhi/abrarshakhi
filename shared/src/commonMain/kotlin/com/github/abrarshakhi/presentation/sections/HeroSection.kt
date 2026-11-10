package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.theme.AppColors
import com.github.abrarshakhi.core.theme.AppShapes
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.core.util.openUrl
import com.github.abrarshakhi.domain.model.Profile
import com.github.abrarshakhi.presentation.components.Avatar
import com.github.abrarshakhi.presentation.components.LinkButton
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SocialRow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroSection(
    profile: Profile,
    onViewWorkClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val window = LocalWindowDimensions.current
    val topPadding = if (window.isCompact) 100.dp else 140.dp

    SectionContainer(
        modifier = modifier.padding(top = topPadding, bottom = AppSpacing.xl),
        topGap = false
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Avatar + Availability Status Badge
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Avatar(
                    initials = profile.initials,
                    size = if (window.isCompact) 68.dp else 84.dp
                )

                if (profile.availability != null) {
                    Spacer(modifier = Modifier.width(AppSpacing.md))
                    AvailabilityBadge(label = profile.availability)
                }
            }

            Spacer(modifier = Modifier.height(AppSpacing.lg))

            // Name
            Text(
                text = profile.name,
                style = if (window.isCompact) {
                    MaterialTheme.typography.displayMedium
                } else {
                    MaterialTheme.typography.displayLarge
                },
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.widthIn(max = 840.dp)
            )

            Spacer(modifier = Modifier.height(AppSpacing.sm))

            // Role
            Text(
                text = profile.role,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(AppSpacing.md))

            // Tagline
            Text(
                text = profile.tagline,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.widthIn(max = 660.dp)
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            // Primary Call to Actions
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
            ) {
                LinkButton(
                    label = "View my work",
                    icon = AppIcons.ArrowDown,
                    isPrimary = true,
                    onClick = onViewWorkClick
                )

                LinkButton(
                    label = "Get in touch",
                    icon = AppIcons.Mail,
                    isPrimary = false,
                    onClick = onContactClick
                )

                if (profile.resumeUrl != null) {
                    LinkButton(
                        label = "Résumé",
                        icon = AppIcons.Document,
                        isPrimary = false,
                        onClick = { openUrl(profile.resumeUrl) }
                    )
                }
            }

            // Social links
            if (profile.socials.isNotEmpty()) {
                Spacer(modifier = Modifier.height(AppSpacing.xl))
                SocialRow(socials = profile.socials)
            }
        }
    }
}

@Composable
private fun AvailabilityBadge(
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerHigh,
                shape = AppShapes.pill
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                shape = AppShapes.pill
            )
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        color = AppColors.AvailableGreen,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(AppSpacing.sm))
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
