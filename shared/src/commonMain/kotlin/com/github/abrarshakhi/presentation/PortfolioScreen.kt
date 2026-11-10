package com.github.abrarshakhi.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.responsive.WindowDimensions
import com.github.abrarshakhi.core.theme.AppSpacing
import com.github.abrarshakhi.domain.model.Portfolio
import com.github.abrarshakhi.presentation.components.LinkButton
import com.github.abrarshakhi.presentation.components.NavLinkItem
import com.github.abrarshakhi.presentation.components.TopNavBar
import com.github.abrarshakhi.presentation.sections.AboutSection
import com.github.abrarshakhi.presentation.sections.ContactSection
import com.github.abrarshakhi.presentation.sections.EducationSection
import com.github.abrarshakhi.presentation.sections.ExperienceSection
import com.github.abrarshakhi.presentation.sections.HeroSection
import com.github.abrarshakhi.presentation.sections.ProjectsSection
import com.github.abrarshakhi.presentation.sections.ResearchSection
import com.github.abrarshakhi.presentation.sections.SkillsSection
import com.github.abrarshakhi.presentation.viewmodel.PortfolioUiState
import com.github.abrarshakhi.presentation.viewmodel.PortfolioViewModel
import kotlinx.coroutines.launch

@Composable
fun PortfolioScreen(
    viewModel: PortfolioViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val isDarkTheme by viewModel.isDarkTheme.collectAsState()

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val windowDimensions = WindowDimensions(
            width = maxWidth,
            height = maxHeight
        )

        CompositionLocalProvider(
            LocalWindowDimensions provides windowDimensions
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    AnimatedContent(
                        targetState = uiState,
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        label = "PortfolioStateAnimation"
                    ) { state ->
                        when (state) {
                            is PortfolioUiState.Loading -> {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                            is PortfolioUiState.Error -> {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = state.message,
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                        Spacer(modifier = Modifier.height(AppSpacing.md))
                                        LinkButton(
                                            label = "Retry",
                                            isPrimary = true,
                                            onClick = { viewModel.loadPortfolio() }
                                        )
                                    }
                                }
                            }
                            is PortfolioUiState.Success -> {
                                PortfolioContentView(
                                    portfolio = state.portfolio,
                                    isDarkTheme = isDarkTheme,
                                    onToggleTheme = { viewModel.toggleTheme() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PortfolioContentView(
    portfolio: Portfolio,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    var aboutOffsetY = 0f
    var workOffsetY = 0f
    var experienceOffsetY = 0f
    var educationOffsetY = 0f
    var skillsOffsetY = 0f
    var contactOffsetY = 0f

    val navItems = buildList {
        if (portfolio.profile.about.isNotEmpty()) {
            add(
                NavLinkItem("About") {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(aboutOffsetY.toInt())
                    }
                }
            )
        }
        if (portfolio.projects.isNotEmpty()) {
            add(
                NavLinkItem("Work") {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(workOffsetY.toInt())
                    }
                }
            )
        }
        if (portfolio.experiences.isNotEmpty()) {
            add(
                NavLinkItem("Experience") {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(experienceOffsetY.toInt())
                    }
                }
            )
        }
        if (portfolio.education.isNotEmpty()) {
            add(
                NavLinkItem("Education") {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(educationOffsetY.toInt())
                    }
                }
            )
        }
        if (portfolio.skillGroups.isNotEmpty()) {
            add(
                NavLinkItem("Skills") {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(skillsOffsetY.toInt())
                    }
                }
            )
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        // Main Scrollable Page
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            HeroSection(
                profile = portfolio.profile,
                onViewWorkClick = {
                    coroutineScope.launch {
                        val target = if (portfolio.projects.isNotEmpty()) workOffsetY else contactOffsetY
                        scrollState.animateScrollTo(target.toInt())
                    }
                },
                onContactClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(contactOffsetY.toInt())
                    }
                }
            )

            if (portfolio.profile.about.isNotEmpty()) {
                Box(modifier = Modifier.onGloballyPositioned { coordinates ->
                    aboutOffsetY = coordinates.positionInParent().y
                }) {
                    AboutSection(profile = portfolio.profile)
                }
            }

            if (portfolio.projects.isNotEmpty()) {
                Box(modifier = Modifier.onGloballyPositioned { coordinates ->
                    workOffsetY = coordinates.positionInParent().y
                }) {
                    ProjectsSection(projects = portfolio.projects)
                }
            }

            if (portfolio.experiences.isNotEmpty()) {
                Box(modifier = Modifier.onGloballyPositioned { coordinates ->
                    experienceOffsetY = coordinates.positionInParent().y
                }) {
                    ExperienceSection(experiences = portfolio.experiences)
                }
            }

            if (portfolio.education.isNotEmpty()) {
                Box(modifier = Modifier.onGloballyPositioned { coordinates ->
                    educationOffsetY = coordinates.positionInParent().y
                }) {
                    EducationSection(education = portfolio.education)
                }
            }

            if (portfolio.research.isNotEmpty()) {
                ResearchSection(research = portfolio.research)
            }

            if (portfolio.skillGroups.isNotEmpty()) {
                Box(modifier = Modifier.onGloballyPositioned { coordinates ->
                    skillsOffsetY = coordinates.positionInParent().y
                }) {
                    SkillsSection(skillGroups = portfolio.skillGroups)
                }
            }

            Box(modifier = Modifier.onGloballyPositioned { coordinates ->
                contactOffsetY = coordinates.positionInParent().y
            }) {
                ContactSection(profile = portfolio.profile)
            }
        }

        // Pinned Top Navigation Bar
        TopNavBar(
            name = portfolio.profile.name,
            navItems = navItems,
            isDarkTheme = isDarkTheme,
            onToggleTheme = onToggleTheme,
            onLogoClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
            onContactClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(contactOffsetY.toInt())
                }
            },
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
