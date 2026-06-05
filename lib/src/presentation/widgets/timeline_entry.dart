import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';

/// A single row in a vertical timeline (used by Experience and Education).
/// A dot-and-line rail runs down the left; the content sits to the right.
class TimelineEntry extends StatelessWidget {
  const TimelineEntry({
    super.key,
    required this.period,
    required this.title,
    required this.subtitle,
    this.trailing,
    this.summary,
    this.bullets = const [],
    this.isLast = false,
  });

  final String period;
  final String title;

  /// Company / institution.
  final String subtitle;

  /// Optional right-aligned meta (e.g. location).
  final String? trailing;
  final String? summary;
  final List<String> bullets;
  final bool isLast;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    return IntrinsicHeight(
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          // Rail: dot + connector line.
          SizedBox(
            width: 16,
            child: Column(
              children: [
                Container(
                  margin: const EdgeInsets.only(top: 5),
                  width: 11,
                  height: 11,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    color: colors.background,
                    border: Border.all(color: colors.accent, width: 2),
                  ),
                ),
                if (!isLast)
                  Expanded(
                    child: Center(
                      child: Container(width: 1.5, color: colors.border),
                    ),
                  ),
              ],
            ),
          ),
          const SizedBox(width: AppSpacing.md),
          // Content.
          Expanded(
            child: Padding(
              padding: EdgeInsets.only(bottom: isLast ? 0 : AppSpacing.xl),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    period,
                    style: text.labelMedium?.copyWith(
                      color: colors.textTertiary,
                    ),
                  ),
                  const SizedBox(height: AppSpacing.xs),
                  Row(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Expanded(child: Text(title, style: text.titleLarge)),
                      if (trailing != null) ...[
                        const SizedBox(width: AppSpacing.sm),
                        Padding(
                          padding: const EdgeInsets.only(top: 3),
                          child: Text(trailing!, style: text.bodySmall),
                        ),
                      ],
                    ],
                  ),
                  const SizedBox(height: 2),
                  Text(
                    subtitle,
                    style: text.titleMedium?.copyWith(color: colors.accent),
                  ),
                  if (summary != null) ...[
                    const SizedBox(height: AppSpacing.sm),
                    Text(summary!, style: text.bodyMedium),
                  ],
                  if (bullets.isNotEmpty) ...[
                    const SizedBox(height: AppSpacing.sm),
                    for (final bullet in bullets) _Bullet(text: bullet),
                  ],
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}

class _Bullet extends StatelessWidget {
  const _Bullet({required this.text});

  final String text;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final style = Theme.of(context).textTheme.bodyMedium;
    return Padding(
      padding: const EdgeInsets.only(top: 6),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.only(top: 9, right: AppSpacing.sm),
            child: Container(
              width: 4,
              height: 4,
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                color: colors.textTertiary,
              ),
            ),
          ),
          Expanded(child: Text(text, style: style)),
        ],
      ),
    );
  }
}
