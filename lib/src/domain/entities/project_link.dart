import 'package:equatable/equatable.dart';
import 'package:flutter/widgets.dart';

class ProjectLink extends Equatable {
  const ProjectLink({
    required this.label,
    required this.url,
    this.icon,
    this.isPrimary = false,
  });

  final String label;
  final String url;
  final IconData? icon;
  final bool isPrimary;

  @override
  List<Object?> get props => [label, url, icon, isPrimary];
}
