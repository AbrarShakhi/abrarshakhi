import 'package:flutter/material.dart';

import '../../core/responsive/responsive.dart';
import '../../core/theme/app_spacing.dart';
import '../../core/utils/url_launcher_util.dart';
import '../../domain/entities/social_link.dart';
import 'hover_region.dart';

/// A horizontal row of social/contact icon buttons.
class SocialRow extends StatelessWidget {
  const SocialRow({super.key, required this.socials});

  final List<SocialLink> socials;

  @override
  Widget build(BuildContext context) {
    return Wrap(
      spacing: AppSpacing.sm,
      runSpacing: AppSpacing.sm,
      children: [for (final social in socials) _SocialButton(social: social)],
    );
  }
}

class _SocialButton extends StatelessWidget {
  const _SocialButton({required this.social});

  final SocialLink social;

  @override
  Widget build(BuildContext context) {
    final colors = context.colors;
    return Tooltip(
      message: social.label,
      child: HoverRegion(
        onTap: () => UrlLauncherUtil.open(social.url),
        builder: (context, hovered, _) {
          return AnimatedContainer(
            duration: const Duration(milliseconds: 160),
            curve: Curves.easeOut,
            width: 42,
            height: 42,
            decoration: BoxDecoration(
              color: hovered ? colors.surfaceMuted : colors.surface,
              borderRadius: BorderRadius.circular(AppRadius.sm),
              border: Border.all(
                color: hovered ? colors.textTertiary : colors.border,
              ),
            ),
            child: Icon(
              social.icon,
              size: 19,
              color: hovered ? colors.accent : colors.textSecondary,
            ),
          );
        },
      ),
    );
  }
}
