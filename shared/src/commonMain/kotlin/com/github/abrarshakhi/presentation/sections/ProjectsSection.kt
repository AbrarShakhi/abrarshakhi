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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.domain.model.Project
import com.github.abrarshakhi.presentation.components.ProjectCard
import com.github.abrarshakhi.presentation.components.SectionContainer
import com.github.abrarshakhi.presentation.components.SectionHeader

@Composable
fun ProjectsSection(
    projects: List<Project>,
    modifier: Modifier = Modifier
) {
    val window = LocalWindowDimensions.current

    SectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SectionHeader(
                eyebrow = "Work",
                title = "Selected projects",
                subtitle = "A collection of software projects, open source tools, and extensions I've designed, developed, and deployed."
            )

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            if (window.isCompact) {
                // 1 column on mobile
                Column(
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.lg),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (project in projects) {
                        ProjectCard(project = project)
                    }
                }
            } else {
                // 2 columns on tablet & desktop
                val chunkedProjects = projects.chunked(2)
                Column(
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.lg),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (row in chunkedProjects) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.lg)
                        ) {
                            for (project in row) {
                                ProjectCard(
                                    project = project,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            // If row has only 1 item in a 2-col layout, add empty spacer
                            if (row.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }
    }
}
