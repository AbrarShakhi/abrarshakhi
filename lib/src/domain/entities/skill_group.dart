import 'package:equatable/equatable.dart';

class SkillGroup extends Equatable {
  const SkillGroup({required this.category, required this.skills});

  final String category;
  final List<String> skills;

  @override
  List<Object?> get props => [category, skills];
}
