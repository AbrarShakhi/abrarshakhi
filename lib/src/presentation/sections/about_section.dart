import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../core/utils/url_launcher_util.dart';
import '../../domain/entities/profile.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/section_header.dart';

class AboutSection extends StatelessWidget {
  const AboutSection({super.key, required this.profile});

  final Profile profile;

  @override
  Widget build(BuildContext context) {
    final text = Theme.of(context).textTheme;

    final paragraphs = Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        for (var i = 0; i < profile.about.length; i++) ...[
          if (i > 0) const SizedBox(height: AppSpacing.md),
          Text(profile.about[i], style: text.bodyLarge),
        ],
      ],
    );

    final factsCard = _FactsCard(profile: profile);

    return SectionContainer(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Reveal(
            child: SectionHeader(eyebrow: 'About', title: 'A bit about me'),
          ),
          const SizedBox(height: AppSpacing.xl),
          Reveal(
            delay: const Duration(milliseconds: 80),
            child: context.isDesktop
                ? Row(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Expanded(flex: 3, child: paragraphs),
                      const SizedBox(width: AppSpacing.xxl),
                      Expanded(flex: 2, child: factsCard),
                    ],
                  )
                : Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      paragraphs,
                      const SizedBox(height: AppSpacing.xl),
                      factsCard,
                    ],
                  ),
          ),
        ],
      ),
    );
  }
}

class _FactsCard extends StatelessWidget {
  const _FactsCard({required this.profile});

  final Profile profile;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return Container(
      padding: const EdgeInsets.all(AppSpacing.lg),
      decoration: BoxDecoration(
        color: colors.surface,
        borderRadius: BorderRadius.circular(AppRadius.lg),
        border: Border.all(color: colors.border),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          if (profile.location != null)
            _FactRow(
              icon: Icons.place_outlined,
              label: 'Location',
              value: profile.location!,
            ),
          _FactRow(
            icon: Icons.mail_outline_rounded,
            label: 'Email',
            value: profile.email,
            onTap: () => UrlLauncherUtil.open('mailto:${profile.email}'),
          ),
          if (profile.availability != null)
            _FactRow(
              icon: Icons.bolt_outlined,
              label: 'Status',
              value: profile.availability!,
            ),
        ],
      ),
    );
  }
}

class _FactRow extends StatelessWidget {
  const _FactRow({
    required this.icon,
    required this.label,
    required this.value,
    this.onTap,
  });

  final IconData icon;
  final String label;
  final String value;
  final VoidCallback? onTap;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    final content = Padding(
      padding: const EdgeInsets.symmetric(vertical: AppSpacing.sm),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Icon(icon, size: 18, color: colors.accent),
          const SizedBox(width: AppSpacing.md),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                label.toUpperCase(),
                style: text.labelMedium?.copyWith(
                  color: colors.textTertiary,
                  letterSpacing: 1.2,
                  fontSize: 11,
                ),
              ),
              const SizedBox(height: 2),
              Text(
                value,
                style: text.titleMedium?.copyWith(
                  color: onTap != null ? colors.accent : colors.textPrimary,
                ),
              ),
            ],
          ),
        ],
      ),
    );

    if (onTap == null) return content;
    return MouseRegion(
      cursor: SystemMouseCursors.click,
      child: GestureDetector(onTap: onTap, child: content),
    );
  }
}
