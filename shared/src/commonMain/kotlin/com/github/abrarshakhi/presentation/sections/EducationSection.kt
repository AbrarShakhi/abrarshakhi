package com.github.abrarshakhi.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.domain.model.Education
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SectionHeader
import com.github.abrarshakhi.presentation.components.TimelineEntry

@Composable
fun EducationSection(
    education: List<Education>,
    modifier: Modifier = Modifier
) {
    if (education.isEmpty()) return

    SectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SectionHeader(
                eyebrow = "Background",
                title = "Education"
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            education.forEachIndexed { index, edu ->
                TimelineEntry(
                    period = edu.period,
                    title = edu.degree,
                    subtitle = edu.institution,
                    location = edu.location,
                    summary = edu.summary,
                    isLast = index == education.lastIndex
                )
            }
        }
    }
}
