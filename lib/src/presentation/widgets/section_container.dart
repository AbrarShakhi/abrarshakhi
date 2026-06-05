import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';

/// Centres a section's content in a max-width column with responsive page
/// gutters and a generous top gap. Every section is wrapped in one of these so
/// the whole page shares a single rhythm.
class SectionContainer extends StatelessWidget {
  const SectionContainer({super.key, required this.child, this.topGap = true});

  final Widget child;

  /// Whether to include the standard vertical gap above the section.
  final bool topGap;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.only(
        left: context.pageGutter,
        right: context.pageGutter,
        top: topGap ? context.sectionGap : 0,
      ),
      child: Center(
        child: ConstrainedBox(
          constraints: const BoxConstraints(
            maxWidth: AppSpacing.maxContentWidth,
          ),
          child: child,
        ),
      ),
    );
  }
}
