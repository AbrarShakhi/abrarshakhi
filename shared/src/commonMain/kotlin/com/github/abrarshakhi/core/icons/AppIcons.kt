package com.github.abrarshakhi.core.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object AppIcons {
    val Code: ImageVector by lazy {
        ImageVector.Builder(
            name = "Code",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(9.4f, 16.6f)
                lineTo(4.8f, 12f)
                lineTo(9.4f, 7.4f)
                lineTo(8f, 6f)
                lineTo(2f, 12f)
                lineTo(8f, 18f)
                close()
                moveTo(14.6f, 16.6f)
                lineTo(19.2f, 12f)
                lineTo(14.6f, 7.4f)
                lineTo(16f, 6f)
                lineTo(22f, 12f)
                lineTo(16f, 18f)
                close()
            }
        }.build()
    }

    val Download: ImageVector by lazy {
        ImageVector.Builder(
            name = "Download",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(19f, 9f)
                horizontalLineTo(15f)
                verticalLineTo(3f)
                horizontalLineTo(9f)
                verticalLineTo(9f)
                horizontalLineTo(5f)
                lineTo(12f, 16f)
                close()
                moveTo(5f, 18f)
                verticalLineTo(20f)
                horizontalLineTo(19f)
                verticalLineTo(18f)
                horizontalLineTo(5f)
                close()
            }
        }.build()
    }

    val ExternalLink: ImageVector by lazy {
        ImageVector.Builder(
            name = "ExternalLink",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(19f, 19f)
                horizontalLineTo(5f)
                verticalLineTo(5f)
                horizontalLineTo(12f)
                verticalLineTo(3f)
                horizontalLineTo(5f)
                curveTo(3.89f, 3f, 3f, 3.9f, 3f, 5f)
                verticalLineTo(19f)
                curveTo(3f, 20.1f, 3.89f, 21f, 5f, 21f)
                horizontalLineTo(19f)
                curveTo(20.1f, 21f, 21f, 20.1f, 21f, 19f)
                verticalLineTo(12f)
                horizontalLineTo(19f)
                verticalLineTo(19f)
                close()
                moveTo(14f, 3f)
                verticalLineTo(5f)
                horizontalLineTo(17.59f)
                lineTo(7.76f, 14.83f)
                lineTo(9.17f, 16.24f)
                lineTo(19f, 6.41f)
                verticalLineTo(10f)
                horizontalLineTo(21f)
                verticalLineTo(3f)
                horizontalLineTo(14f)
                close()
            }
        }.build()
    }

    val Mail: ImageVector by lazy {
        ImageVector.Builder(
            name = "Mail",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(20f, 4f)
                horizontalLineTo(4f)
                curveTo(2.9f, 4f, 2.01f, 4.9f, 2.01f, 6f)
                lineTo(2f, 18f)
                curveTo(2f, 19.1f, 2.9f, 20f, 4f, 20f)
                horizontalLineTo(20f)
                curveTo(21.1f, 20f, 22f, 19.1f, 22f, 18f)
                verticalLineTo(6f)
                curveTo(22f, 4.9f, 21.1f, 4f, 20f, 4f)
                close()
                moveTo(20f, 8f)
                lineTo(12f, 13f)
                lineTo(4f, 8f)
                verticalLineTo(6f)
                lineTo(12f, 11f)
                lineTo(20f, 6f)
                verticalLineTo(8f)
                close()
            }
        }.build()
    }

    val Location: ImageVector by lazy {
        ImageVector.Builder(
            name = "Location",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 2f)
                curveTo(8.13f, 2f, 5f, 5.13f, 5f, 9f)
                curveTo(5f, 14.25f, 12f, 22f, 12f, 22f)
                curveTo(12f, 22f, 19f, 14.25f, 19f, 9f)
                curveTo(19f, 5.13f, 15.87f, 2f, 12f, 2f)
                close()
                moveTo(12f, 11.5f)
                curveTo(10.62f, 11.5f, 9.5f, 10.38f, 9.5f, 9f)
                curveTo(9.5f, 7.62f, 10.62f, 6.5f, 12f, 6.5f)
                curveTo(13.38f, 6.5f, 14.5f, 7.62f, 14.5f, 9f)
                curveTo(14.5f, 10.38f, 13.38f, 11.5f, 12f, 11.5f)
                close()
            }
        }.build()
    }

    val Bolt: ImageVector by lazy {
        ImageVector.Builder(
            name = "Bolt",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(11f, 21f)
                horizontalLineTo(13f)
                lineTo(18f, 11f)
                horizontalLineTo(13f)
                lineTo(14f, 3f)
                horizontalLineTo(12f)
                lineTo(7f, 13f)
                horizontalLineTo(12f)
                close()
            }
        }.build()
    }

    val ArrowDown: ImageVector by lazy {
        ImageVector.Builder(
            name = "ArrowDown",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(20f, 12f)
                lineTo(18.59f, 10.59f)
                lineTo(13f, 16.17f)
                verticalLineTo(4f)
                horizontalLineTo(11f)
                verticalLineTo(16.17f)
                lineTo(5.41f, 10.59f)
                lineTo(4f, 12f)
                lineTo(12f, 20f)
                close()
            }
        }.build()
    }

    val Document: ImageVector by lazy {
        ImageVector.Builder(
            name = "Document",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(14f, 2f)
                horizontalLineTo(6f)
                curveTo(4.9f, 2f, 4.01f, 2.9f, 4.01f, 4f)
                lineTo(4f, 20f)
                curveTo(4f, 21.1f, 4.89f, 22f, 5.99f, 22f)
                horizontalLineTo(18f)
                curveTo(19.1f, 22f, 20f, 21.1f, 20f, 20f)
                verticalLineTo(8f)
                lineTo(14f, 2f)
                close()
                moveTo(16f, 18f)
                horizontalLineTo(8f)
                verticalLineTo(16f)
                horizontalLineTo(16f)
                verticalLineTo(18f)
                close()
                moveTo(16f, 14f)
                horizontalLineTo(8f)
                verticalLineTo(12f)
                horizontalLineTo(16f)
                verticalLineTo(14f)
                close()
                moveTo(13f, 9f)
                verticalLineTo(3.5f)
                lineTo(18.5f, 9f)
                horizontalLineTo(13f)
                close()
            }
        }.build()
    }

    val LightMode: ImageVector by lazy {
        ImageVector.Builder(
            name = "LightMode",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 7f)
                curveTo(9.24f, 7f, 7f, 9.24f, 7f, 12f)
                curveTo(7f, 14.76f, 9.24f, 17f, 12f, 17f)
                curveTo(14.76f, 17f, 17f, 14.76f, 17f, 12f)
                curveTo(17f, 9.24f, 14.76f, 7f, 12f, 7f)
                close()
                moveTo(12f, 2f)
                horizontalLineTo(11f)
                verticalLineTo(4f)
                horizontalLineTo(12f)
                close()
                moveTo(12f, 20f)
                horizontalLineTo(11f)
                verticalLineTo(22f)
                horizontalLineTo(12f)
                close()
                moveTo(4f, 12f)
                verticalLineTo(11f)
                horizontalLineTo(2f)
                verticalLineTo(12f)
                close()
                moveTo(22f, 12f)
                verticalLineTo(11f)
                horizontalLineTo(20f)
                verticalLineTo(12f)
                close()
            }
        }.build()
    }

    val DarkMode: ImageVector by lazy {
        ImageVector.Builder(
            name = "DarkMode",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12.3f, 2f)
                curveTo(6.78f, 2.19f, 2.37f, 6.78f, 2.6f, 12.32f)
                curveTo(2.81f, 17.38f, 6.94f, 21.48f, 12f, 21.5f)
                curveTo(14.28f, 21.5f, 16.39f, 20.73f, 18.08f, 19.42f)
                curveTo(18.66f, 18.97f, 18.29f, 18f, 17.55f, 18.06f)
                curveTo(14.47f, 18.31f, 11.45f, 16.59f, 10.45f, 13.37f)
                curveTo(9.19f, 9.27f, 11.6f, 5.17f, 15.34f, 4.29f)
                curveTo(16.09f, 4.12f, 16.3f, 3.12f, 15.65f, 2.72f)
                curveTo(14.62f, 2.09f, 13.48f, 2f, 12.3f, 2f)
                close()
            }
        }.build()
    }

    val Menu: ImageVector by lazy {
        ImageVector.Builder(
            name = "Menu",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(3f, 18f)
                horizontalLineTo(21f)
                verticalLineTo(16f)
                horizontalLineTo(3f)
                verticalLineTo(18f)
                close()
                moveTo(3f, 13f)
                horizontalLineTo(21f)
                verticalLineTo(11f)
                horizontalLineTo(3f)
                verticalLineTo(13f)
                close()
                moveTo(3f, 6f)
                verticalLineTo(8f)
                horizontalLineTo(21f)
                verticalLineTo(6f)
                horizontalLineTo(3f)
                close()
            }
        }.build()
    }

    val Close: ImageVector by lazy {
        ImageVector.Builder(
            name = "Close",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(19f, 6.41f)
                lineTo(17.59f, 5f)
                lineTo(12f, 10.59f)
                lineTo(6.41f, 5f)
                lineTo(5f, 6.41f)
                lineTo(10.59f, 12f)
                lineTo(5f, 17.59f)
                lineTo(6.41f, 19f)
                lineTo(12f, 13.41f)
                lineTo(17.59f, 19f)
                lineTo(19f, 17.59f)
                lineTo(13.41f, 12f)
                close()
            }
        }.build()
    }

    val School: ImageVector by lazy {
        ImageVector.Builder(
            name = "School",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(5f, 13.18f)
                verticalLineTo(17.18f)
                lineTo(12f, 21f)
                lineTo(19f, 17.18f)
                verticalLineTo(13.18f)
                lineTo(12f, 17f)
                lineTo(5f, 13.18f)
                close()
                moveTo(12f, 3f)
                lineTo(1f, 9f)
                lineTo(12f, 15f)
                lineTo(21f, 10.09f)
                verticalLineTo(17f)
                horizontalLineTo(23f)
                verticalLineTo(9f)
                lineTo(12f, 3f)
                close()
            }
        }.build()
    }

    val Work: ImageVector by lazy {
        ImageVector.Builder(
            name = "Work",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(20f, 6f)
                horizontalLineTo(16f)
                verticalLineTo(4f)
                curveTo(16f, 2.9f, 15.1f, 2f, 14f, 2f)
                horizontalLineTo(10f)
                curveTo(8.9f, 2f, 8f, 2.9f, 8f, 4f)
                verticalLineTo(6f)
                horizontalLineTo(4f)
                curveTo(2.9f, 6f, 2f, 6.9f, 2f, 8f)
                verticalLineTo(19f)
                curveTo(2f, 20.1f, 2.9f, 21f, 4f, 21f)
                horizontalLineTo(20f)
                curveTo(21.1f, 21f, 22f, 20.1f, 22f, 19f)
                verticalLineTo(8f)
                curveTo(22f, 6.9f, 21.1f, 6f, 20f, 6f)
                close()
                moveTo(10f, 4f)
                horizontalLineTo(14f)
                verticalLineTo(6f)
                horizontalLineTo(10f)
                verticalLineTo(4f)
                close()
            }
        }.build()
    }
}
