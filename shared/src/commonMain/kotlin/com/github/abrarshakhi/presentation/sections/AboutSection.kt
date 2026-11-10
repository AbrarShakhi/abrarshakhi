package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.theme.AppShapes
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.core.util.openUrl
import com.github.abrarshakhi.domain.model.Profile
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SectionHeader

@Composable
fun AboutSection(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    val window = LocalWindowDimensions.current

    SectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SectionHeader(
                eyebrow = "About",
                title = "A bit about me"
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            if (window.isExpanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier.weight(3f)
                    ) {
                        BioParagraphs(about = profile.about)
                    }

                    Spacer(modifier = Modifier.width(AppSpacing.xxl))

                    Column(
                        modifier = Modifier.weight(2f)
                    ) {
                        FactsCard(profile = profile)
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BioParagraphs(about = profile.about)
                    Spacer(modifier = Modifier.height(AppSpacing.xl))
                    FactsCard(profile = profile)
                }
            }
        }
    }
}

@Composable
private fun BioParagraphs(
    about: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        about.forEachIndexed { index, paragraph ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(AppSpacing.md))
            }
            Text(
                text = paragraph,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun FactsCard(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = AppShapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.lg)
        ) {
            if (profile.location != null) {
                FactItem(
                    icon = AppIcons.Location,
                    label = "Location",
                    value = profile.location
                )
            }

            FactItem(
                icon = AppIcons.Mail,
                label = "Email",
                value = profile.email,
                onClick = { openUrl("mailto:${profile.email}") }
            )

            if (profile.availability != null) {
                FactItem(
                    icon = AppIcons.Bolt,
                    label = "Status",
                    value = profile.availability
                )
            }
        }
    }
}

@Composable
private fun FactItem(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(AppShapes.small)
            .then(
                if (onClick != null) {
                    Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClick
                    )
                } else Modifier
            )
            .padding(vertical = AppSpacing.sm),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(AppSpacing.md))

        Column {
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.labelSmall.copy(
                    letterSpacing = 1.2.sp,
                    color = MaterialTheme.colorScheme.outline
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                color = if (onClick != null) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )
        }
    }
}
