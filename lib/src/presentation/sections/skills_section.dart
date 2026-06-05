import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../domain/entities/skill_group.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/section_header.dart';
import '../widgets/tag_chip.dart';

/// Skills grouped by category, shown as a tidy definition-list of chips.
class SkillsSection extends StatelessWidget {
  const SkillsSection({super.key, required this.groups});

  final List<SkillGroup> groups;

  @override
  Widget build(BuildContext context) {
    return SectionContainer(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Reveal(
            child: SectionHeader(eyebrow: 'Toolkit', title: 'Skills'),
          ),
          const SizedBox(height: AppSpacing.xl),
          for (var i = 0; i < groups.length; i++) ...[
            if (i > 0) const SizedBox(height: AppSpacing.lg),
            Reveal(
              delay: Duration(milliseconds: 50 * i),
              child: _SkillGroupRow(group: groups[i]),
            ),
          ],
        ],
      ),
    );
  }
}

class _SkillGroupRow extends StatelessWidget {
  const _SkillGroupRow({required this.group});

  final SkillGroup group;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    final label = Text(
      group.category,
      style: text.titleMedium?.copyWith(color: colors.textSecondary),
    );
    final chips = Wrap(
      spacing: AppSpacing.sm,
      runSpacing: AppSpacing.sm,
      children: [for (final skill in group.skills) TagChip(skill)],
    );

    if (!context.isDesktop) {
      return Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          label,
          const SizedBox(height: AppSpacing.md),
          chips,
        ],
      );
    }

    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        SizedBox(
          width: 180,
          child: Padding(padding: const EdgeInsets.only(top: 4), child: label),
        ),
        Expanded(child: chips),
      ],
    );
  }
}
