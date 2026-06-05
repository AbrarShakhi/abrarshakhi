import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../core/utils/url_launcher_util.dart';
import '../../domain/entities/profile.dart';
import '../widgets/link_button.dart';
import '../widgets/reveal.dart';
import '../widgets/section_container.dart';
import '../widgets/social_row.dart';

/// Closing call-to-action panel plus the page footer.
class ContactSection extends StatelessWidget {
  const ContactSection({super.key, required this.profile});

  final Profile profile;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;

    return Column(
      children: [
        SectionContainer(
          child: Reveal(
            child: Container(
              width: double.infinity,
              padding: EdgeInsets.symmetric(
                horizontal: context.responsive<double>(mobile: 24, desktop: 56),
                vertical: context.responsive<double>(mobile: 40, desktop: 64),
              ),
              decoration: BoxDecoration(
                color: colors.surfaceMuted,
                borderRadius: BorderRadius.circular(AppRadius.xl),
                border: Border.all(color: colors.border),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('Let’s work together', style: text.displaySmall),
                  const SizedBox(height: AppSpacing.md),
                  ConstrainedBox(
                    constraints: const BoxConstraints(maxWidth: 560),
                    child: Text(
                      'Have a role, a project, or just want to say hi? '
                      'My inbox is always open.',
                      style: text.bodyLarge,
                    ),
                  ),
                  const SizedBox(height: AppSpacing.xl),
                  Wrap(
                    spacing: AppSpacing.sm,
                    runSpacing: AppSpacing.sm,
                    children: [
                      LinkButton(
                        label: profile.email,
                        icon: Icons.mail_outline_rounded,
                        primary: true,
                        onTap: () =>
                            UrlLauncherUtil.open('mailto:${profile.email}'),
                      ),
                      if (profile.resumeUrl != null)
                        LinkButton(
                          label: 'Download résumé',
                          icon: Icons.download_rounded,
                          onTap: () => UrlLauncherUtil.open(profile.resumeUrl!),
                        ),
                    ],
                  ),
                  if (profile.socials.isNotEmpty) ...[
                    const SizedBox(height: AppSpacing.xl),
                    SocialRow(socials: profile.socials),
                  ],
                ],
              ),
            ),
          ),
        ),
        const SizedBox(height: AppSpacing.xxl),
        _Footer(name: profile.name),
      ],
    );
  }
}

class _Footer extends StatelessWidget {
  const _Footer({required this.name});

  final String name;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    final text = Theme.of(context).textTheme;
    final year = DateTime.now().year;

    return Container(
      decoration: BoxDecoration(
        border: Border(top: BorderSide(color: colors.border)),
      ),
      padding: EdgeInsets.symmetric(
        horizontal: context.pageGutter,
        vertical: AppSpacing.lg,
      ),
      child: Center(
        child: ConstrainedBox(
          constraints: const BoxConstraints(
            maxWidth: AppSpacing.maxContentWidth,
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Flexible(child: Text('© $year $name', style: text.bodySmall)),
              const SizedBox(width: AppSpacing.md),
              Text('Built with Flutter', style: text.bodySmall),
            ],
          ),
        ),
      ),
    );
  }
}
