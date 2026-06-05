import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../core/utils/url_launcher_util.dart';
import '../../domain/entities/research.dart';
import '../widgets/link_button.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/section_header.dart';

/// Publications / research, rendered as a clean list with optional links.
class ResearchSection extends StatelessWidget {
  const ResearchSection({super.key, required this.research});

  final List<Research> research;

  @override
  Widget build(BuildContext context) {
    return SectionContainer(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Reveal(
            child: SectionHeader(
              eyebrow: 'Research',
              title: 'Publications & writing',
            ),
          ),
          const SizedBox(height: AppSpacing.xl),
          for (var i = 0; i < research.length; i++)
            Reveal(
              delay: Duration(milliseconds: 60 * i),
              child: _ResearchTile(
                research: research[i],
                isLast: i == research.length - 1,
              ),
            ),
        ],
      ),
    );
  }
}

class _ResearchTile extends StatelessWidget {
  const _ResearchTile({required this.research, required this.isLast});

  final Research research;
  final bool isLast;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    return Container(
      padding: const EdgeInsets.symmetric(vertical: AppSpacing.lg),
      decoration: BoxDecoration(
        border: Border(
          bottom: BorderSide(
            color: isLast ? Colors.transparent : colors.border,
          ),
        ),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            '${research.venue}  ·  ${research.year}',
            style: text.labelMedium?.copyWith(color: colors.accent),
          ),
          const SizedBox(height: AppSpacing.xs),
          Text(research.title, style: text.titleLarge),
          if (research.summary != null) ...[
            const SizedBox(height: AppSpacing.sm),
            ConstrainedBox(
              constraints: const BoxConstraints(maxWidth: 720),
              child: Text(research.summary!, style: text.bodyMedium),
            ),
          ],
          if (research.url != null) ...[
            const SizedBox(height: AppSpacing.md),
            LinkButton(
              label: 'Read paper',
              icon: Icons.open_in_new_rounded,
              onTap: () => UrlLauncherUtil.open(research.url!),
            ),
          ],
        ],
      ),
    );
  }
}
