import 'package:equatable/equatable.dart';

/// An academic entry in the Education timeline.
class Education extends Equatable {
  const Education({
    required this.degree,
    required this.institution,
    required this.period,
    this.location,
    this.summary,
  });

  final String degree;
  final String institution;
  final String period;
  final String? location;
  final String? summary;

  @override
  List<Object?> get props => [degree, institution, period, location, summary];
}
