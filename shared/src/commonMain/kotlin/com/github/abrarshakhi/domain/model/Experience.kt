package com.github.abrarshakhi.domain.model

data class Experience(
    val role: String,
    val company: String,
    val period: String,
    val location: String? = null,
    val summary: String? = null,
    val highlights: List<String> = emptyList()
)
