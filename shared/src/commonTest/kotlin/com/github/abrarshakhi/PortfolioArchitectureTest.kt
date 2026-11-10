package com.github.abrarshakhi

import com.github.abrarshakhi.data.datasource.PortfolioLocalDataSource
import com.github.abrarshakhi.domain.model.Profile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PortfolioArchitectureTest {

    @Test
    fun profileInitialsCalculation() {
        val profile = Profile(
            name = "MD. Shakhiul Abrar",
            role = "CS student",
            tagline = "Android",
            about = listOf("Bio"),
            email = "test@example.com"
        )
        assertEquals("MA", profile.initials)

        val singleName = profile.copy(name = "Abrar")
        assertEquals("A", singleName.initials)

        val multiPartName = profile.copy(name = "John Middle Doe")
        assertEquals("JD", multiPartName.initials)
    }

    @Test
    fun localDataSourceContentIntegrity() {
        val portfolio = PortfolioLocalDataSource.portfolioContent
        assertEquals("MD. Shakhiul Abrar", portfolio.profile.name)
        assertTrue(portfolio.projects.isNotEmpty(), "Portfolio should have projects")
        assertTrue(portfolio.education.isNotEmpty(), "Portfolio should have education")
        assertTrue(portfolio.skillGroups.isNotEmpty(), "Portfolio should have skill groups")
        assertTrue(portfolio.profile.socials.isNotEmpty(), "Profile should have social links")
    }

    @Test
    fun projectLinksHaveValidConfiguration() {
        val projects = PortfolioLocalDataSource.portfolioContent.projects
        for (project in projects) {
            assertTrue(project.title.isNotBlank(), "Project title must not be blank")
            assertTrue(project.links.isNotEmpty(), "Project should have links")
            for (link in project.links) {
                assertTrue(link.url.startsWith("http"), "URL must start with http: ${link.url}")
            }
        }
    }
}
