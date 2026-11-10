package com.github.abrarshakhi.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.abrarshakhi.core.icons.AppIcons
import com.github.abrarshakhi.core.responsive.LocalWindowDimensions
import com.github.abrarshakhi.core.responsive.ResponsiveLayout
import com.github.abrarshakhi.core.theme.AppShapes
import com.github.abrarshakhi.core.theme.AppSpacing

data class NavLinkItem(
    val label: String,
    val onClick: () -> Unit
)

@Composable
fun TopNavBar(
    name: String,
    navItems: List<NavLinkItem>,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onLogoClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val window = LocalWindowDimensions.current
    val gutter = ResponsiveLayout.pageGutter()
    var isMobileMenuOpen by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background.copy(alpha = 0.92f),
        tonalElevation = 2.dp,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppSpacing.topNavHeight)
                    .padding(horizontal = gutter),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = AppSpacing.maxContentWidth),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Brand / Logo
                    BrandLogo(
                        name = name,
                        onClick = onLogoClick
                    )

                    // Desktop Navigation Links
                    if (window.isExpanded) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (item in navItems) {
                                NavTextLink(
                                    label = item.label,
                                    onClick = item.onClick
                                )
                                Spacer(modifier = Modifier.width(AppSpacing.md))
                            }

                            // Theme Toggle Button
                            ThemeToggleButton(
                                isDark = isDarkTheme,
                                onToggle = onToggleTheme
                            )

                            Spacer(modifier = Modifier.width(AppSpacing.sm))

                            // Contact CTA
                            LinkButton(
                                label = "Contact",
                                isPrimary = true,
                                onClick = onContactClick
                            )
                        }
                    } else {
                        // Mobile / Tablet action bar
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ThemeToggleButton(
                                isDark = isDarkTheme,
                                onToggle = onToggleTheme
                            )

                            Spacer(modifier = Modifier.width(AppSpacing.xs))

                            IconButton(
                                onClick = { isMobileMenuOpen = !isMobileMenuOpen }
                            ) {
                                Icon(
                                    imageVector = if (isMobileMenuOpen) AppIcons.Close else AppIcons.Menu,
                                    contentDescription = "Toggle Menu",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }

            // Mobile Dropdown Drawer
            AnimatedVisibility(
                visible = !window.isExpanded && isMobileMenuOpen,
                enter = expandVertically(tween(220)) + fadeIn(tween(220)),
                exit = shrinkVertically(tween(180)) + fadeOut(tween(180))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                        .padding(horizontal = gutter, vertical = AppSpacing.md)
                ) {
                    for (item in navItems) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(AppShapes.small)
                                .clickable {
                                    isMobileMenuOpen = false
                                    item.onClick()
                                }
                                .padding(vertical = 12.dp, horizontal = 12.dp)
                        ) {
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = AppSpacing.sm),
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                    )

                    LinkButton(
                        label = "Contact Me",
                        isPrimary = true,
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            isMobileMenuOpen = false
                            onContactClick()
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun BrandLogo(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val textColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onBackground
        },
        animationSpec = tween(durationMillis = 180)
    )

    Row(
        modifier = modifier
            .clip(AppShapes.small)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(vertical = 6.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = AppShapes.pill
                )
        )
        Spacer(modifier = Modifier.width(AppSpacing.sm))
        Text(
            text = name,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        )
    }
}

@Composable
private fun NavTextLink(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val textColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        animationSpec = tween(durationMillis = 160)
    )

    Box(
        modifier = modifier
            .clip(AppShapes.small)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge.copy(
                color = textColor,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
private fun ThemeToggleButton(
    isDark: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val containerColor by animateColorAsState(
        targetValue = if (isHovered) {
            MaterialTheme.colorScheme.surfaceContainerHighest
        } else {
            MaterialTheme.colorScheme.surfaceContainerLow
        },
        animationSpec = tween(160)
    )

    OutlinedButton(
        onClick = onToggle,
        modifier = modifier.size(42.dp),
        interactionSource = interactionSource,
        shape = AppShapes.small,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
    ) {
        Icon(
            imageVector = if (isDark) AppIcons.LightMode else AppIcons.DarkMode,
            contentDescription = if (isDark) "Switch to Light Mode" else "Switch to Dark Mode",
            modifier = Modifier.size(19.dp)
        )
    }
}
