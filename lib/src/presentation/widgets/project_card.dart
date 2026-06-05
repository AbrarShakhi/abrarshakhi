import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../core/utils/url_launcher_util.dart';
import '../../domain/entities/project.dart';
import 'hover_region.dart';
import 'link_button.dart';
import 'tag_chip.dart';

/// A single project tile: title + year, summary, tag chips and any number of
/// link buttons. Lifts and warms its border on hover.
class ProjectCard extends StatelessWidget {
  const ProjectCard({super.key, required this.project});

  final Project project;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    return HoverRegion(
      cursor: SystemMouseCursors.basic,
      builder: (context, hovered, _) {
        return AnimatedContainer(
          duration: const Duration(milliseconds: 200),
          curve: Curves.easeOut,
          transform: Matrix4.translationValues(0, hovered ? -4 : 0, 0),
          padding: const EdgeInsets.all(AppSpacing.lg),
          decoration: BoxDecoration(
            color: colors.surface,
            borderRadius: BorderRadius.circular(AppRadius.lg),
            border: Border.all(
              color: hovered
                  ? colors.accent.withValues(alpha: 0.6)
                  : colors.border,
            ),
            boxShadow: hovered
                ? [
                    BoxShadow(
                      color: colors.textPrimary.withValues(alpha: 0.06),
                      blurRadius: 24,
                      offset: const Offset(0, 12),
                    ),
                  ]
                : null,
          ),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Expanded(child: Text(project.title, style: text.titleLarge)),
                  if (project.year != null) ...[
                    const SizedBox(width: AppSpacing.sm),
                    Padding(
                      padding: const EdgeInsets.only(top: 4),
                      child: Text(project.year!, style: text.bodySmall),
                    ),
                  ],
                ],
              ),
              const SizedBox(height: AppSpacing.sm),
              Text(project.summary, style: text.bodyMedium),
              if (project.tags.isNotEmpty) ...[
                const SizedBox(height: AppSpacing.md),
                Wrap(
                  spacing: AppSpacing.sm,
                  runSpacing: AppSpacing.sm,
                  children: [for (final tag in project.tags) TagChip(tag)],
                ),
              ],
              if (project.links.isNotEmpty) ...[
                const SizedBox(height: AppSpacing.lg),
                Wrap(
                  spacing: AppSpacing.sm,
                  runSpacing: AppSpacing.sm,
                  children: [
                    for (final link in project.links)
                      LinkButton(
                        label: link.label,
                        icon: link.icon,
                        primary: link.isPrimary,
                        onTap: () => UrlLauncherUtil.open(link.url),
                      ),
                  ],
                ),
              ],
            ],
          ),
        );
      },
    );
  }
}
