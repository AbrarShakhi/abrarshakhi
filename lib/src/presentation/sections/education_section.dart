import 'package:flutter/material.dart';

import '../../core/theme/app_spacing.dart';
import '../../domain/entities/education.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/section_header.dart';
import '../widgets/timeline_entry.dart';

/// Academic background as a vertical timeline.
class EducationSection extends StatelessWidget {
  const EducationSection({super.key, required this.education});

  final List<Education> education;

  @override
  Widget build(BuildContext context) {
    return SectionContainer(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Reveal(
            child: SectionHeader(eyebrow: 'Background', title: 'Education'),
          ),
          const SizedBox(height: AppSpacing.xl),
          for (var i = 0; i < education.length; i++)
            Reveal(
              delay: Duration(milliseconds: 60 * i),
              child: TimelineEntry(
                period: education[i].period,
                title: education[i].degree,
                subtitle: education[i].institution,
                trailing: education[i].location,
                summary: education[i].summary,
                isLast: i == education.length - 1,
              ),
            ),
        ],
      ),
    );
  }
}
