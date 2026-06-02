import 'package:equatable/equatable.dart';
import 'package:flutter/widgets.dart';

class SocialLink extends Equatable {
  const SocialLink({
    required this.label,
    required this.url,
    required this.icon,
  });

  final String label;
  final String url;
  final IconData icon;

  @override
  List<Object?> get props => [label, url, icon];
}
