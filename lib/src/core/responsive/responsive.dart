import 'package:flutter/material.dart';

import '../theme/app_colors.dart';
import '../theme/app_spacing.dart';

/// Layout breakpoints (in logical pixels).
abstract final class Breakpoints {
  static const double mobile = 640;
  static const double tablet = 1024;
}

/// Convenience accessors for theme + screen size, so widgets stay terse:
/// `context.colors.accent`, `context.isMobile`, etc.
extension ResponsiveContext on BuildContext {
  /// The semantic palette for the active theme (light/dark).
  AppColors get colors =>
      Theme.of(this).extension<AppColors>() ?? AppColors.light;

  double get screenWidth => MediaQuery.sizeOf(this).width;

  bool get isMobile => screenWidth < Breakpoints.mobile;
  bool get isTablet =>
      screenWidth >= Breakpoints.mobile && screenWidth < Breakpoints.tablet;
  bool get isDesktop => screenWidth >= Breakpoints.tablet;

  /// Horizontal page gutter that tightens on small screens.
  double get pageGutter =>
      isMobile ? AppSpacing.pageGutterMobile : AppSpacing.pageGutter;

  /// Vertical gap between sections, tightened on small screens.
  double get sectionGap =>
      isMobile ? AppSpacing.sectionGapMobile : AppSpacing.sectionGap;

  /// Picks the value matching the current breakpoint, falling back upward.
  T responsive<T>({required T mobile, T? tablet, T? desktop}) {
    if (isDesktop) return desktop ?? tablet ?? mobile;
    if (isTablet) return tablet ?? mobile;
    return mobile;
  }
}
