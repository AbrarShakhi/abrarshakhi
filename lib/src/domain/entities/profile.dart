import 'package:equatable/equatable.dart';

import 'social_link.dart';

class Profile extends Equatable {
  const Profile({
    required this.name,
    required this.role,
    required this.tagline,
    required this.about,
    required this.email,
    this.location,
    this.availability,
    this.resumeUrl,
    this.socials = const [],
  });

  final String name;
  final String role;
  final String tagline;
  final List<String> about;
  final String email;
  final String? location;
  final String? availability;
  final String? resumeUrl;
  final List<SocialLink> socials;

  String get initials {
    final parts = name.trim().split(RegExp(r'\s+'));
    if (parts.isEmpty || parts.first.isEmpty) return '';
    if (parts.length == 1) return parts.first.substring(0, 1).toUpperCase();
    return (parts.first.substring(0, 1) + parts.last.substring(0, 1))
        .toUpperCase();
  }

  @override
  List<Object?> get props => [
    name,
    role,
    tagline,
    about,
    email,
    location,
    availability,
    resumeUrl,
    socials,
  ];
}
