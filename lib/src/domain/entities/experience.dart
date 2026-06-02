import 'package:equatable/equatable.dart';

class Experience extends Equatable {
  const Experience({
    required this.role,
    required this.company,
    required this.period,
    this.location,
    this.summary,
    this.highlights = const [],
  });

  final String role;
  final String company;
  final String period;
  final String? location;
  final String? summary;
  final List<String> highlights;

  @override
  List<Object?> get props => [
    role,
    company,
    period,
    location,
    summary,
    highlights,
  ];
}
