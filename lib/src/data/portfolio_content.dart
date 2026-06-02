import 'package:flutter/material.dart';

import '../domain/entities/portfolio.dart';
import '../domain/entities/profile.dart';
import '../domain/entities/social_link.dart';

const Portfolio portfolioContent = Portfolio(
  // ----------------------------------------------------------------------- //
  //  PROFILE — the hero + about header.
  // ----------------------------------------------------------------------- //
  profile: Profile(
    name: 'MD. Shakhiul Abrar',
    role: 'CS student @ East West University',
    tagline: "Android - Machine Learning - Systems",
    about: [
      'Placeholder: MD. Shakhiul Abrar',
      'Android - Machine Learning - Systems. CS student @ East West University',
    ],
    email: 'willBeAdded@later.com',
    location: 'Dhaka, Bangladesh',
    availability: 'Open to opportunities',
    resumeUrl: 'https://willBeAdded/resume.pdf',
    socials: [
      SocialLink(
        label: 'GitHub',
        url: 'https://github.com/AbrarShakhi',
        icon: Icons.code_rounded,
      ),
      // SocialLink(
      //   label: 'LinkedIn',
      //   url: 'https://linkedin.com/in/abrarshakhi',
      //   icon: Icons.business_outlined,
      // ),
      SocialLink(
        label: 'Email',
        url: 'mailto:willBeAdded@later.com',
        icon: Icons.mail_outline_rounded,
      ),
    ],
  ),
);
