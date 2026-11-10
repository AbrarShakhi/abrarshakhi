package com.github.abrarshakhi.domain.model

data class Research(
    val title: String,
    val venue: String,
    val year: String,
    val summary: String? = null,
    val url: String? = null
)
