import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';

/// A circular monogram avatar. Falls back to initials over a soft accent wash —
/// no image asset required for the dummy site.
///
/// To use a photo instead, swap the child for an [Image]/[CircleAvatar] with a
/// `backgroundImage` (see DOCS.md).
class Avatar extends StatelessWidget {
  const Avatar({super.key, required this.initials, this.size = 72});

  final String initials;
  final double size;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return Container(
      width: size,
      height: size,
      alignment: Alignment.center,
      decoration: BoxDecoration(
        shape: BoxShape.circle,
        color: colors.accent.withValues(alpha: 0.12),
        border: Border.all(color: colors.accent.withValues(alpha: 0.35)),
      ),
      child: Text(
        initials,
        style: Theme.of(context).textTheme.titleLarge?.copyWith(
          color: colors.accent,
          fontSize: size * 0.34,
        ),
      ),
    );
  }
}
