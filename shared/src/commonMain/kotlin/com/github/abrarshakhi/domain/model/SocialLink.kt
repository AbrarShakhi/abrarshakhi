package com.github.abrarshakhi.domain.model

enum class SocialIconType {
    GITHUB,
    LINKEDIN,
    EMAIL,
    GENERIC
}

data class SocialLink(
    val label: String,
    val url: String,
    val iconType: SocialIconType = SocialIconType.GENERIC
)
