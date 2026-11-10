package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.core.util.openUrl
import com.github.abrarshakhi.domain.model.Research
import com.github.abrarshakhi.presentation.components.LinkButton
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SectionHeader

@Composable
fun ResearchSection(
    research: List<Research>,
    modifier: Modifier = Modifier
) {
    if (research.isEmpty()) return

    SectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SectionHeader(
                eyebrow = "Research",
                title = "Publications & writing"
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            research.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppSpacing.md)
                ) {
                    Text(
                        text = "${item.venue}  •  ${item.year}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(AppSpacing.xs))

                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (item.summary != null) {
                        Spacer(modifier = Modifier.height(AppSpacing.sm))
                        Text(
                            text = item.summary,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    if (item.url != null) {
                        Spacer(modifier = Modifier.height(AppSpacing.md))
                        LinkButton(
                            label = "Read paper",
                            icon = AppIcons.ExternalLink,
                            onClick = { openUrl(item.url) }
                        )
                    }

                    if (index < research.lastIndex) {
                        Spacer(modifier = Modifier.height(AppSpacing.lg))
                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
    }
}
