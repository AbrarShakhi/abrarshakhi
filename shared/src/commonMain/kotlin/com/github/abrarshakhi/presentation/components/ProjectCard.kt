package com.github.abrarshakhi.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.theme.AppShapes
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.core.util.openUrl
import com.github.abrarshakhi.domain.model.Project
import com.github.abrarshakhi.domain.model.ProjectIconType

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val offsetY by animateDpAsState(
        targetValue = if (isHovered) (-4).dp else 0.dp,
        animationSpec = tween(durationMillis = 200)
    )

    val borderColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.primary.copy(alpha = 0.65f)
        } else {
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        },
        animationSpec = tween(durationMillis = 200)
    )

    val containerColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.surfaceContainerHigh
        } else {
            MaterialTheme.colorScheme.surfaceContainerLow
        },
        animationSpec = tween(durationMillis = 200)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .offset(y = offsetY),
        shape = AppShapes.large,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.lg)
        ) {
            // Header: Title + Year
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )

                if (project.year != null) {
                    Spacer(modifier = Modifier.width(AppSpacing.sm))
                    Text(
                        text = project.year,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(AppSpacing.sm))

            // Summary
            Text(
                text = project.summary,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Tags
            if (project.tags.isNotEmpty()) {
                Spacer(modifier = Modifier.height(AppSpacing.md))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs),
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.xs)
                ) {
                    for (tag in project.tags) {
                        TagChip(label = tag)
                    }
                }
            }

            // Links
            if (project.links.isNotEmpty()) {
                Spacer(modifier = Modifier.height(AppSpacing.lg))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                ) {
                    for (link in project.links) {
                        val icon = when (link.iconType) {
                            ProjectIconType.CODE -> AppIcons.Code
                            ProjectIconType.DOWNLOAD -> AppIcons.Download
                            ProjectIconType.DOCUMENT -> AppIcons.Document
                            ProjectIconType.EXTERNAL -> AppIcons.ExternalLink
                        }

                        LinkButton(
                            label = link.label,
                            icon = icon,
                            isPrimary = link.isPrimary,
                            onClick = { openUrl(link.url) }
                        )
                    }
                }
            }
        }
    }
}
