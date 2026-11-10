package com.github.abrarshakhi.domain.model

data class Education(
    val degree: String,
    val institution: String,
    val period: String,
    val location: String? = null,
    val summary: String? = null
)
