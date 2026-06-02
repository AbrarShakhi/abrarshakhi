import 'package:equatable/equatable.dart';

import 'project_link.dart';

class Project extends Equatable {
  const Project({
    required this.title,
    required this.summary,
    this.year,
    this.tags = const [],
    this.links = const [],
  });

  final String title;
  final String summary;
  final String? year;
  final List<String> tags;
  final List<ProjectLink> links;

  @override
  List<Object?> get props => [title, summary, year, tags, links];
}
