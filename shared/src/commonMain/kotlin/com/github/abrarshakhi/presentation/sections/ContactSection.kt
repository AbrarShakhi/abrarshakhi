package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.responsive.ResponsiveLayout
import com.github.abrarshakhi.core.theme.AppShapes
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.core.util.openUrl
import com.github.abrarshakhi.domain.model.Profile
import com.github.abrarshakhi.presentation.components.LinkButton
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SocialRow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContactSection(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    val window = LocalWindowDimensions.current

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        SectionContainer {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = AppShapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                ),
                border = BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = if (window.isCompact) AppSpacing.lg else AppSpacing.xxl,
                            vertical = if (window.isCompact) AppSpacing.xl else AppSpacing.xxl
                        )
                ) {
                    Text(
                        text = "Let’s connect & collaborate",
                        style = if (window.isCompact) {
                            MaterialTheme.typography.headlineMedium
                        } else {
                            MaterialTheme.typography.displaySmall
                        },
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(AppSpacing.md))

                    Text(
                        text = "Whether you have an exciting software role, open source idea, machine learning project, or just want to chat tech — my inbox is always open.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.widthIn(max = 620.dp)
                    )

                    Spacer(modifier = Modifier.height(AppSpacing.xl))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                        verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                    ) {
                        LinkButton(
                            label = profile.email,
                            icon = AppIcons.Mail,
                            isPrimary = true,
                            onClick = { openUrl("mailto:${profile.email}") }
                        )

                        if (profile.resumeUrl != null) {
                            LinkButton(
                                label = "Download résumé",
                                icon = AppIcons.Download,
                                isPrimary = false,
                                onClick = { openUrl(profile.resumeUrl) }
                            )
                        }
                    }

                    if (profile.socials.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(AppSpacing.xl))
                        SocialRow(socials = profile.socials)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(AppSpacing.xxl))

        Footer(name = profile.name)
    }
}

@Composable
private fun Footer(
    name: String,
    modifier: Modifier = Modifier
) {
    val gutter = ResponsiveLayout.pageGutter()

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = gutter, vertical = AppSpacing.xl),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = AppSpacing.maxContentWidth),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "© 2026 $name",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = "Built with Compose Multiplatform & KMP",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
