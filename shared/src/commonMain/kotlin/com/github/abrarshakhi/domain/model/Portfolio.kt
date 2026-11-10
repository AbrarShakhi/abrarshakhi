package com.github.abrarshakhi.domain.model

data class Portfolio(
    val profile: Profile,
    val projects: List<Project> = emptyList(),
    val experiences: List<Experience> = emptyList(),
    val education: List<Education> = emptyList(),
    val research: List<Research> = emptyList(),
    val skillGroups: List<SkillGroup> = emptyList()
)
