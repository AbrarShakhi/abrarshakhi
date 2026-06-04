import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

import 'app_colors.dart';

abstract final class AppTheme {
  static TextStyle _serif(TextStyle style) =>
      GoogleFonts.fraunces(textStyle: style);

  static TextStyle _sans(TextStyle style) =>
      GoogleFonts.inter(textStyle: style);

  static ThemeData light() => _build(AppColors.light, Brightness.light);
  static ThemeData dark() => _build(AppColors.dark, Brightness.dark);

  static ThemeData _build(AppColors c, Brightness brightness) {
    final base = brightness == Brightness.light
        ? const ColorScheme.light()
        : const ColorScheme.dark();

    final colorScheme = base.copyWith(
      brightness: brightness,
      primary: c.accent,
      onPrimary: c.onAccent,
      secondary: c.accent,
      surface: c.surface,
      onSurface: c.textPrimary,
      onSurfaceVariant: c.textSecondary,
      outline: c.border,
      outlineVariant: c.border,
    );

    return ThemeData(
      useMaterial3: true,
      brightness: brightness,
      colorScheme: colorScheme,
      scaffoldBackgroundColor: c.background,
      extensions: <ThemeExtension<dynamic>>[c],
      textTheme: _textTheme(c),
      splashFactory: NoSplash.splashFactory,
      hoverColor: Colors.transparent,
      highlightColor: Colors.transparent,
      dividerColor: c.border,
      iconTheme: IconThemeData(color: c.textSecondary, size: 20),
    );
  }

  static TextTheme _textTheme(AppColors c) {
    return TextTheme(
      displayLarge: _serif(
        TextStyle(
          fontSize: 56,
          height: 1.05,
          fontWeight: FontWeight.w600,
          letterSpacing: -1.2,
          color: c.textPrimary,
        ),
      ),
      displayMedium: _serif(
        TextStyle(
          fontSize: 42,
          height: 1.08,
          fontWeight: FontWeight.w600,
          letterSpacing: -0.8,
          color: c.textPrimary,
        ),
      ),

      displaySmall: _serif(
        TextStyle(
          fontSize: 32,
          height: 1.15,
          fontWeight: FontWeight.w600,
          letterSpacing: -0.5,
          color: c.textPrimary,
        ),
      ),
      headlineMedium: _serif(
        TextStyle(
          fontSize: 24,
          height: 1.2,
          fontWeight: FontWeight.w600,
          color: c.textPrimary,
        ),
      ),

      titleLarge: _sans(
        TextStyle(
          fontSize: 20,
          height: 1.3,
          fontWeight: FontWeight.w600,
          letterSpacing: -0.2,
          color: c.textPrimary,
        ),
      ),
      titleMedium: _sans(
        TextStyle(
          fontSize: 16,
          height: 1.4,
          fontWeight: FontWeight.w600,
          color: c.textPrimary,
        ),
      ),

      bodyLarge: _sans(
        TextStyle(
          fontSize: 18,
          height: 1.6,
          fontWeight: FontWeight.w400,
          color: c.textSecondary,
        ),
      ),
      bodyMedium: _sans(
        TextStyle(
          fontSize: 15,
          height: 1.6,
          fontWeight: FontWeight.w400,
          color: c.textSecondary,
        ),
      ),
      bodySmall: _sans(
        TextStyle(
          fontSize: 13,
          height: 1.5,
          fontWeight: FontWeight.w400,
          color: c.textTertiary,
        ),
      ),

      labelLarge: _sans(
        TextStyle(
          fontSize: 14,
          height: 1.2,
          fontWeight: FontWeight.w600,
          letterSpacing: 0.1,
          color: c.textPrimary,
        ),
      ),
      labelMedium: _sans(
        TextStyle(
          fontSize: 13,
          height: 1.2,
          fontWeight: FontWeight.w500,
          letterSpacing: 0.2,
          color: c.textSecondary,
        ),
      ),
    );
  }
}
