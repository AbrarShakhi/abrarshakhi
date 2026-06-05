import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';

/// A consistent section heading: a small clay "eyebrow" label above a large
/// serif title, optionally followed by a short subtitle.
class SectionHeader extends StatelessWidget {
  const SectionHeader({
    super.key,
    required this.eyebrow,
    required this.title,
    this.subtitle,
  });

  final String eyebrow;
  final String title;
  final String? subtitle;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              width: 18,
              height: 1.5,
              color: colors.accent,
              margin: const EdgeInsets.only(right: AppSpacing.sm, bottom: 2),
            ),
            Text(
              eyebrow.toUpperCase(),
              style: text.labelMedium?.copyWith(
                color: colors.accent,
                letterSpacing: 1.4,
                fontWeight: FontWeight.w600,
              ),
            ),
          ],
        ),
        const SizedBox(height: AppSpacing.md),
        Text(title, style: text.displaySmall),
        if (subtitle != null) ...[
          const SizedBox(height: AppSpacing.md),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 620),
            child: Text(subtitle!, style: text.bodyLarge),
          ),
        ],
      ],
    );
  }
}
