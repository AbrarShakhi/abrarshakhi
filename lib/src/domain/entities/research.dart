import 'package:equatable/equatable.dart';

class Research extends Equatable {
  const Research({
    required this.title,
    required this.venue,
    required this.year,
    this.summary,
    this.url,
  });

  final String title;
  final String venue;
  final String year;
  final String? summary;
  final String? url;

  @override
  List<Object?> get props => [title, venue, year, summary, url];
}
