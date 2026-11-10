package com.github.abrarshakhi.domain.model

data class Project(
    val title: String,
    val summary: String,
    val year: String? = null,
    val tags: List<String> = emptyList(),
    val links: List<ProjectLink> = emptyList()
)
