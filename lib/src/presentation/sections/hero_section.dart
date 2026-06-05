import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../core/utils/url_launcher_util.dart';
import '../../domain/entities/profile.dart';
import '../widgets/avatar.dart';
import '../widgets/link_button.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/social_row.dart';

/// The opening screen: name, role, tagline and primary calls-to-action.
class HeroSection extends StatelessWidget {
  const HeroSection({
    super.key,
    required this.profile,
    required this.onViewWork,
    required this.onContact,
  });

  final Profile profile;
  final VoidCallback onViewWork;
  final VoidCallback onContact;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;
    final topPad = context.responsive<double>(mobile: 120, desktop: 168);

    return SectionContainer(
      topGap: false,
      child: Padding(
        padding: EdgeInsets.only(top: topPad, bottom: AppSpacing.xl),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Reveal(
              child: Row(
                children: [
                  Avatar(initials: profile.initials),
                  const SizedBox(width: AppSpacing.md),
                  if (profile.availability != null)
                    _AvailabilityBadge(label: profile.availability!),
                ],
              ),
            ),
            const SizedBox(height: AppSpacing.lg),
            Reveal(
              delay: const Duration(milliseconds: 60),
              child: ConstrainedBox(
                constraints: const BoxConstraints(maxWidth: 760),
                child: Text(profile.name, style: text.displayLarge),
              ),
            ),
            const SizedBox(height: AppSpacing.md),
            Reveal(
              delay: const Duration(milliseconds: 120),
              child: Text(
                profile.role,
                style: text.titleLarge?.copyWith(color: colors.accent),
              ),
            ),
            const SizedBox(height: AppSpacing.md),
            Reveal(
              delay: const Duration(milliseconds: 180),
              child: ConstrainedBox(
                constraints: const BoxConstraints(maxWidth: 640),
                child: Text(profile.tagline, style: text.bodyLarge),
              ),
            ),
            const SizedBox(height: AppSpacing.xl),
            Reveal(
              delay: const Duration(milliseconds: 240),
              child: Wrap(
                spacing: AppSpacing.sm,
                runSpacing: AppSpacing.sm,
                crossAxisAlignment: WrapCrossAlignment.center,
                children: [
                  LinkButton(
                    label: 'View my work',
                    icon: Icons.arrow_downward_rounded,
                    primary: true,
                    onTap: onViewWork,
                  ),
                  LinkButton(
                    label: 'Get in touch',
                    icon: Icons.mail_outline_rounded,
                    onTap: onContact,
                  ),
                  if (profile.resumeUrl != null)
                    LinkButton(
                      label: 'Résumé',
                      icon: Icons.description_outlined,
                      onTap: () => UrlLauncherUtil.open(profile.resumeUrl!),
                    ),
                ],
              ),
            ),
            if (profile.socials.isNotEmpty) ...[
              const SizedBox(height: AppSpacing.xl),
              Reveal(
                delay: const Duration(milliseconds: 300),
                child: SocialRow(socials: profile.socials),
              ),
            ],
          ],
        ),
      ),
    );
  }
}

class _AvailabilityBadge extends StatelessWidget {
  const _AvailabilityBadge({required this.label});

  final String label;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
      decoration: BoxDecoration(
        color: colors.surfaceMuted,
        borderRadius: BorderRadius.circular(AppRadius.pill),
        border: Border.all(color: colors.border),
      ),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Container(
            width: 8,
            height: 8,
            decoration: const BoxDecoration(
              shape: BoxShape.circle,
              color: Color(0xFF4F9D69),
            ),
          ),
          const SizedBox(width: AppSpacing.sm),
          Text(
            label,
            style: Theme.of(
              context,
            ).textTheme.labelMedium?.copyWith(color: colors.textSecondary),
          ),
        ],
      ),
    );
  }
}
