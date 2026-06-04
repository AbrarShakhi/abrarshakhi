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
  const TopNavBar({super.key, required this.name, required this.items});

  static const double height = 64;

  final String name;
  final List<NavItem> items;

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
                  const Spacer(),
                  if (showLinks) ...[
                    for (final item in items)
                      Padding(
                        padding: const EdgeInsets.only(left: AppSpacing.lg),
                        child: _NavLink(item: item),
                      ),
                    const SizedBox(width: AppSpacing.lg),
                  ],
                  if (showLinks) ...[
                    const SizedBox(width: AppSpacing.sm),
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
