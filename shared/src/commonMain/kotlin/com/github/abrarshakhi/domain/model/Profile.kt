package com.github.abrarshakhi.domain.model

data class Profile(
    val name: String,
    val role: String,
    val tagline: String,
    val about: List<String>,
    val email: String,
    val location: String? = null,
    val availability: String? = null,
    val resumeUrl: String? = null,
    val socials: List<SocialLink> = emptyList()
) {
    val initials: String
        get() {
            val parts = name.trim().split(Regex("\\s+"))
            if (parts.isEmpty() || parts.first().isEmpty()) return ""
            if (parts.size == 1) return parts.first().take(1).uppercase()
            return (parts.first().take(1) + parts.last().take(1)).uppercase()
        }
}
