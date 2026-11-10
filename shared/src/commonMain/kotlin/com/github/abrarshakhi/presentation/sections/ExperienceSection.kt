package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.domain.model.Experience
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SectionHeader
import com.github.abrarshakhi.presentation.components.TimelineEntry

@Composable
fun ExperienceSection(
    experiences: List<Experience>,
    modifier: Modifier = Modifier
) {
    if (experiences.isEmpty()) return

    SectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SectionHeader(
                eyebrow = "Career",
                title = "Work experience"
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            experiences.forEachIndexed { index, exp ->
                TimelineEntry(
                    period = exp.period,
                    title = exp.role,
                    subtitle = exp.company,
                    location = exp.location,
                    summary = exp.summary,
                    bullets = exp.highlights,
                    isLast = index == experiences.lastIndex
                )
            }
        }
    }
}
