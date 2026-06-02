import 'package:equatable/equatable.dart';

import 'education.dart';
import 'experience.dart';
import 'profile.dart';
import 'project.dart';
import 'research.dart';
import 'skill_group.dart';

class Portfolio extends Equatable {
  const Portfolio({
    required this.profile,
    this.projects = const [],
    this.experiences = const [],
    this.education = const [],
    this.research = const [],
    this.skillGroups = const [],
  });

  final Profile profile;
  final List<Project> projects;
  final List<Experience> experiences;
  final List<Education> education;
  final List<Research> research;
  final List<SkillGroup> skillGroups;

  @override
  List<Object?> get props => [
    profile,
    projects,
    experiences,
    education,
    research,
    skillGroups,
  ];
}
