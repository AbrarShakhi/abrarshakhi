package com.github.abrarshakhi.data.datasource

import com.github.abrarshakhi.domain.model.Education
import com.github.abrarshakhi.domain.model.Experience
import com.github.abrarshakhi.domain.model.Portfolio
import com.github.abrarshakhi.domain.model.Profile
import com.github.abrarshakhi.domain.model.Project
import com.github.abrarshakhi.domain.model.ProjectIconType
import com.github.abrarshakhi.domain.model.ProjectLink
import com.github.abrarshakhi.domain.model.Research
import com.github.abrarshakhi.domain.model.SkillGroup
import com.github.abrarshakhi.domain.model.SocialIconType
import com.github.abrarshakhi.domain.model.SocialLink

class PortfolioLocalDataSource : PortfolioDataSource {

    override suspend fun getPortfolio(): Portfolio {
        return portfolioContent
    }

    companion object {
        val portfolioContent = Portfolio(
            profile = Profile(
                name = "MD. Shakhiul Abrar",
                role = "CS student @ East West University",
                tagline = "Android • Machine Learning • Systems",
                about = listOf(
                    "I am currently studying Computer Science and Engineering at East West University.",
                    "Passionate about building performant mobile and web applications with Kotlin Multiplatform, exploring machine learning models, and diving deep into systems programming."
                ),
                email = "willBeAdded@later.com",
                location = "Dhaka, Bangladesh",
                availability = "Open to opportunities",
                resumeUrl = "https://willBeAdded/resume.pdf",
                socials = listOf(
                    SocialLink(
                        label = "GitHub",
                        url = "https://github.com/AbrarShakhi",
                        iconType = SocialIconType.GITHUB
                    ),
                    SocialLink(
                        label = "Email",
                        url = "mailto:willBeAdded@later.com",
                        iconType = SocialIconType.EMAIL
                    )
                )
            ),
            projects = listOf(
                Project(
                    title = "Banglish",
                    year = "2024",
                    summary = "Custom Linux shell written in C exploring process management, system calls, and terminal I/O.",
                    tags = listOf("C", "CLI", "Shell", "Linux", "Systems"),
                    links = listOf(
                        ProjectLink(
                            label = "Source",
                            url = "https://github.com/AbrarShakhi/banglish",
                            iconType = ProjectIconType.CODE,
                            isPrimary = true
                        )
                    )
                ),
                Project(
                    title = "quick-run-in-terminal",
                    year = "2024",
                    summary = "VS Code extension allowing developers to rapidly execute source files across multiple programming languages directly in the integrated terminal.",
                    tags = listOf("VS Code", "TypeScript", "Node.js", "Extension"),
                    links = listOf(
                        ProjectLink(
                            label = "Source",
                            url = "https://github.com/AbrarShakhi/quick-run-in-terminal",
                            iconType = ProjectIconType.CODE,
                            isPrimary = true
                        ),
                        ProjectLink(
                            label = "Marketplace",
                            url = "https://marketplace.visualstudio.com/items?itemName=AbrarShakhi.quick-run-in-terminal",
                            iconType = ProjectIconType.DOWNLOAD,
                            isPrimary = false
                        )
                    )
                )
            ),
            experiences = emptyList(),
            education = listOf(
                Education(
                    degree = "B.Sc. in Computer Science & Engineering",
                    institution = "East West University",
                    period = "2022 — Present",
                    location = "Dhaka, Bangladesh",
                    summary = "Undergraduate studies with focus on Software Engineering, Data Structures, Algorithms, and Distributed Systems."
                ),
                Education(
                    degree = "Higher Secondary Certificate",
                    institution = "Example College",
                    period = "2018 — 2020",
                    location = "Dhaka, Bangladesh",
                    summary = "Science concentration. Active participant in programming contests and science olympiads."
                )
            ),
            research = emptyList(),
            skillGroups = listOf(
                SkillGroup(
                    category = "Languages",
                    skills = listOf("Kotlin", "Java", "C / C++", "Python", "Dart", "TypeScript")
                ),
                SkillGroup(
                    category = "Frameworks & UI",
                    skills = listOf("Compose Multiplatform", "Jetpack Compose", "Flutter", "Android SDK")
                ),
                SkillGroup(
                    category = "Machine Learning",
                    skills = listOf("PyTorch", "NumPy", "Pandas", "Scikit-Learn", "OpenCV")
                ),
                SkillGroup(
                    category = "Tools & Systems",
                    skills = listOf("Linux", "Docker", "Git", "PostgreSQL", "Redis")
                )
            )
        )
    }
}
