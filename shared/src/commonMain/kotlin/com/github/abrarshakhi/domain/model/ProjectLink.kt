package com.github.abrarshakhi.domain.model

enum class ProjectIconType {
    CODE,
    DOWNLOAD,
    DOCUMENT,
    EXTERNAL
}

data class ProjectLink(
    val label: String,
    val url: String,
    val iconType: ProjectIconType = ProjectIconType.EXTERNAL,
    val isPrimary: Boolean = false
)
