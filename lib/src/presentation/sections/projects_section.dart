import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../domain/entities/project.dart';
import '../widgets/project_card.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/section_header.dart';

/// A responsive grid of project cards (two columns on wide screens, one on
/// mobile). Cards reveal with a gentle stagger.
class ProjectsSection extends StatelessWidget {
  const ProjectsSection({super.key, required this.projects});

  final List<Project> projects;

  @override
  Widget build(BuildContext context) {
    const gap = AppSpacing.lg;
    final columns = context.responsive<int>(mobile: 1, tablet: 2, desktop: 2);

    return SectionContainer(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Reveal(
            child: SectionHeader(
              eyebrow: 'Work',
              title: 'Selected projects',
              subtitle:
                  'A few things I’ve designed, built and shipped. Each links out '
                  'to a demo, the source, or more detail.',
            ),
          ),
          const SizedBox(height: AppSpacing.xl),
          LayoutBuilder(
            builder: (context, constraints) {
              final cardWidth =
                  (constraints.maxWidth - gap * (columns - 1)) / columns;
              return Wrap(
                spacing: gap,
                runSpacing: gap,
                children: [
                  for (var i = 0; i < projects.length; i++)
                    SizedBox(
                      width: cardWidth,
                      child: Reveal(
                        delay: Duration(milliseconds: 60 * (i % columns)),
                        child: ProjectCard(project: projects[i]),
                      ),
                    ),
                ],
              );
            },
          ),
        ],
      ),
    );
  }
}
