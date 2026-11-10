package com.github.abrarshakhi.core.util

import kotlinx.browser.window

actual fun openUrl(url: String) {
    try {
        window.open(url, "_blank")
    } catch (_: Throwable) {
        // Fallback or ignore in headless tests
    }
}
