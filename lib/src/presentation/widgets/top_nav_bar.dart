import 'dart:ui';

import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import 'hover_region.dart';

class NavItem {
  const NavItem(this.label, this.onTap);
  final String label;
  final VoidCallback onTap;
}

class TopNavBar extends StatelessWidget {
  const TopNavBar({
    super.key,
    required this.name,
    required this.items,
    required this.onLogoTap,
    required this.onToggleTheme,
    required this.isDark,
    required this.onContact,
  });

  static const double height = 64;

  final String name;
  final List<NavItem> items;
  final VoidCallback onLogoTap;
  final VoidCallback onToggleTheme;
  final bool isDark;
  final VoidCallback onContact;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final showLinks = context.isDesktop;

    return ClipRect(
      child: BackdropFilter(
        filter: ImageFilter.blur(sigmaX: 12, sigmaY: 12),
        child: Container(
          height: height,
          decoration: BoxDecoration(
            color: colors.background.withValues(alpha: 0.78),
            border: Border(bottom: BorderSide(color: colors.border)),
          ),
          padding: EdgeInsets.symmetric(horizontal: context.pageGutter),
          child: Center(
            child: ConstrainedBox(
              constraints: const BoxConstraints(
                maxWidth: AppSpacing.maxContentWidth,
              ),
              child: Row(
                children: [
                  _Logo(name: name, onTap: onLogoTap),
                  const Spacer(),
                  if (showLinks) ...[
                    for (final item in items)
                      Padding(
                        padding: const EdgeInsets.only(left: AppSpacing.lg),
                        child: _NavLink(item: item),
                      ),
                    const SizedBox(width: AppSpacing.lg),
                  ],
                  _ThemeToggle(isDark: isDark, onTap: onToggleTheme),
                  if (showLinks) ...[
                    const SizedBox(width: AppSpacing.sm),
                    _ContactPill(onTap: onContact),
                  ] else ...[
                    const SizedBox(width: AppSpacing.xs),
                    _MenuButton(items: items),
                  ],
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class _Logo extends StatelessWidget {
  const _Logo({required this.name, required this.onTap});

  final String name;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return HoverRegion(
      onTap: onTap,
      builder: (context, hovered, _) {
        return Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              width: 10,
              height: 10,
              margin: const EdgeInsets.only(right: AppSpacing.sm),
              decoration: BoxDecoration(
                color: colors.accent,
                borderRadius: BorderRadius.circular(3),
              ),
            ),
            Text(
              name,
              style: Theme.of(context).textTheme.titleMedium?.copyWith(
                color: hovered ? colors.accent : colors.textPrimary,
              ),
            ),
          ],
        );
      },
    );
  }
}

class _NavLink extends StatelessWidget {
  const _NavLink({required this.item});

  final NavItem item;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return HoverRegion(
      onTap: item.onTap,
      builder: (context, hovered, _) {
        return Text(
          item.label,
          style: Theme.of(context).textTheme.labelLarge?.copyWith(
            fontWeight: FontWeight.w500,
            color: hovered ? colors.textPrimary : colors.textSecondary,
          ),
        );
      },
    );
  }
}

class _ContactPill extends StatelessWidget {
  const _ContactPill({required this.onTap});

  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return HoverRegion(
      onTap: onTap,
      builder: (context, hovered, _) {
        return AnimatedContainer(
          duration: const Duration(milliseconds: 160),
          padding: const EdgeInsets.symmetric(
            horizontal: AppSpacing.md,
            vertical: 8,
          ),
          decoration: BoxDecoration(
            color: hovered ? colors.accentHover : colors.accent,
            borderRadius: BorderRadius.circular(AppRadius.sm),
          ),
          child: Text(
            'Contact',
            style: Theme.of(
              context,
            ).textTheme.labelLarge?.copyWith(color: colors.onAccent),
          ),
        );
      },
    );
  }
}

class _ThemeToggle extends StatelessWidget {
  const _ThemeToggle({required this.isDark, required this.onTap});

  final bool isDark;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return HoverRegion(
      onTap: onTap,
      builder: (context, hovered, _) {
        return Container(
          width: 38,
          height: 38,
          decoration: BoxDecoration(
            color: hovered ? colors.surfaceMuted : Colors.transparent,
            borderRadius: BorderRadius.circular(AppRadius.sm),
          ),
          child: Icon(
            isDark ? Icons.light_mode_outlined : Icons.dark_mode_outlined,
            size: 19,
            color: colors.textSecondary,
          ),
        );
      },
    );
  }
}

class _MenuButton extends StatelessWidget {
  const _MenuButton({required this.items});

  final List<NavItem> items;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return PopupMenuButton<int>(
      tooltip: 'Menu',
      icon: Icon(Icons.menu_rounded, color: colors.textSecondary),
      color: colors.surface,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(AppRadius.md),
        side: BorderSide(color: colors.border),
      ),
      onSelected: (i) => items[i].onTap(),
      itemBuilder: (context) => [
        for (var i = 0; i < items.length; i++)
          PopupMenuItem<int>(
            value: i,
            child: Text(
              items[i].label,
              style: Theme.of(context).textTheme.labelLarge,
            ),
          ),
      ],
    );
  }
}
