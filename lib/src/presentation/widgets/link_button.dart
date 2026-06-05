import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import 'hover_region.dart';

/// The site's one button. [primary] renders filled (clay accent); otherwise it
/// renders as a quiet outlined button. Both animate softly on hover.
class LinkButton extends StatelessWidget {
  const LinkButton({
    super.key,
    required this.label,
    required this.onTap,
    this.icon,
    this.primary = false,
  });

  final String label;
  final VoidCallback onTap;
  final IconData? icon;
  final bool primary;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final textStyle = Theme.of(context).textTheme.labelLarge!;

    return HoverRegion(
      onTap: onTap,
      builder: (context, hovered, _) {
        final Color background;
        final Color foreground;
        final Color borderColor;

        if (primary) {
          background = hovered ? colors.accentHover : colors.accent;
          foreground = colors.onAccent;
          borderColor = background;
        } else {
          background = hovered ? colors.surfaceMuted : colors.surface;
          foreground = colors.textPrimary;
          borderColor = hovered ? colors.textTertiary : colors.border;
        }

        return AnimatedContainer(
          duration: const Duration(milliseconds: 160),
          curve: Curves.easeOut,
          padding: const EdgeInsets.symmetric(
            horizontal: AppSpacing.md,
            vertical: 11,
          ),
          decoration: BoxDecoration(
            color: background,
            borderRadius: BorderRadius.circular(AppRadius.sm),
            border: Border.all(color: borderColor),
          ),
          child: Row(
            mainAxisSize: MainAxisSize.min,
            children: [
              if (icon != null) ...[
                Icon(icon, size: 16, color: foreground),
                const SizedBox(width: AppSpacing.sm),
              ],
              Text(label, style: textStyle.copyWith(color: foreground)),
            ],
          ),
        );
      },
    );
  }
}
