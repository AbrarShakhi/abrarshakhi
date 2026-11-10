package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.domain.model.SkillGroup
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SectionHeader
import com.github.abrarshakhi.presentation.components.TagChip

@Composable
fun SkillsSection(
    skillGroups: List<SkillGroup>,
    modifier: Modifier = Modifier
) {
    if (skillGroups.isEmpty()) return
    val window = LocalWindowDimensions.current

    SectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SectionHeader(
                eyebrow = "Toolkit",
                title = "Technical skills"
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            Column(
                verticalArrangement = Arrangement.spacedBy(AppSpacing.lg),
                modifier = Modifier.fillMaxWidth()
            ) {
                for (group in skillGroups) {
                    SkillGroupRow(
                        group = group,
                        isExpanded = window.isExpanded
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SkillGroupRow(
    group: SkillGroup,
    isExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    if (isExpanded) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = group.category,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.width(200.dp)
            )

            FlowRow(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
            ) {
                for (skill in group.skills) {
                    TagChip(label = skill)
                }
            }
        }
    } else {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = group.category,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(AppSpacing.sm))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
            ) {
                for (skill in group.skills) {
                    TagChip(label = skill)
                }
            }
        }
    }
}
