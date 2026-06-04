import 'package:flutter/material.dart';

class AppColors extends ThemeExtension<AppColors> {
  const AppColors({
    required this.background,
    required this.surface,
    required this.surfaceMuted,
    required this.border,
    required this.textPrimary,
    required this.textSecondary,
    required this.textTertiary,
    required this.accent,
    required this.accentHover,
    required this.onAccent,
  });

  final Color background;
  final Color surface;
  final Color surfaceMuted;
  final Color border;
  final Color textPrimary;
  final Color textSecondary;
  final Color textTertiary;
  final Color accent;
  final Color accentHover;
  final Color onAccent;

  static const AppColors light = AppColors(
    background: Color(0xFFFAF9F5),
    surface: Color(0xFFFFFFFF),
    surfaceMuted: Color(0xFFEFEFEA),
    border: Color(0xFFE3E2DC),
    textPrimary: Color(0xFF1A1915),
    textSecondary: Color(0xFF6F6E66),
    textTertiary: Color(0xFF9A9890),
    accent: Color(0xFF2D63C8),
    accentHover: Color(0xFF234FA3),
    onAccent: Color(0xFFFAFBFF),
  );

  static const AppColors dark = AppColors(
    background: Color(0xFF24252A),
    surface: Color(0xFF2E3036),
    surfaceMuted: Color(0xFF383A41),
    border: Color(0xFF44464E),
    textPrimary: Color(0xFFF3F3F0),
    textSecondary: Color(0xFFB4B5B0),
    textTertiary: Color(0xFF84858A),
    accent: Color(0xFF6B9BF2),
    accentHover: Color(0xFF87AEF7),
    onAccent: Color(0xFF15171C),
  );

  @override
  AppColors copyWith({
    Color? background,
    Color? surface,
    Color? surfaceMuted,
    Color? border,
    Color? textPrimary,
    Color? textSecondary,
    Color? textTertiary,
    Color? accent,
    Color? accentHover,
    Color? onAccent,
  }) {
    return AppColors(
      background: background ?? this.background,
      surface: surface ?? this.surface,
      surfaceMuted: surfaceMuted ?? this.surfaceMuted,
      border: border ?? this.border,
      textPrimary: textPrimary ?? this.textPrimary,
      textSecondary: textSecondary ?? this.textSecondary,
      textTertiary: textTertiary ?? this.textTertiary,
      accent: accent ?? this.accent,
      accentHover: accentHover ?? this.accentHover,
      onAccent: onAccent ?? this.onAccent,
    );
  }

  @override
  AppColors lerp(ThemeExtension<AppColors>? other, double t) {
    if (other is! AppColors) return this;
    return AppColors(
      background: Color.lerp(background, other.background, t)!,
      surface: Color.lerp(surface, other.surface, t)!,
      surfaceMuted: Color.lerp(surfaceMuted, other.surfaceMuted, t)!,
      border: Color.lerp(border, other.border, t)!,
      textPrimary: Color.lerp(textPrimary, other.textPrimary, t)!,
      textSecondary: Color.lerp(textSecondary, other.textSecondary, t)!,
      textTertiary: Color.lerp(textTertiary, other.textTertiary, t)!,
      accent: Color.lerp(accent, other.accent, t)!,
      accentHover: Color.lerp(accentHover, other.accentHover, t)!,
      onAccent: Color.lerp(onAccent, other.onAccent, t)!,
    );
  }
}
