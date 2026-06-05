import 'package:flutter/material.dart';

import '../../core/theme/app_spacing.dart';
import '../../domain/entities/experience.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/section_header.dart';
import '../widgets/timeline_entry.dart';

/// Work history as a vertical timeline.
class ExperienceSection extends StatelessWidget {
  const ExperienceSection({super.key, required this.experiences});

  final List<Experience> experiences;

  @override
  Widget build(BuildContext context) {
    return SectionContainer(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Reveal(
            child: SectionHeader(eyebrow: 'Career', title: 'Experience'),
          ),
          const SizedBox(height: AppSpacing.xl),
          for (var i = 0; i < experiences.length; i++)
            Reveal(
              delay: Duration(milliseconds: 60 * i),
              child: TimelineEntry(
                period: experiences[i].period,
                title: experiences[i].role,
                subtitle: experiences[i].company,
                trailing: experiences[i].location,
                summary: experiences[i].summary,
                bullets: experiences[i].highlights,
                isLast: i == experiences.length - 1,
              ),
            ),
        ],
      ),
    );
  }
}
