import 'package:flutter/material.dart';

import '../domain/entities/education.dart';
import '../domain/entities/experience.dart';
import '../domain/entities/portfolio.dart';
import '../domain/entities/profile.dart';
import '../domain/entities/project.dart';
import '../domain/entities/project_link.dart';
import '../domain/entities/research.dart';
import '../domain/entities/skill_group.dart';
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
      'This about page is intensionally left like this. becasue I will edit this later.'
          'I\'m currenly studying compiter science in East West University',
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

  // ----------------------------------------------------------------------- //
  //  PROJECTS — each card has a title, summary, tags and any number of links.
  // ----------------------------------------------------------------------- //
  projects: [
    // Project(
    //   title: 'Eddit',
    //   year: '2026',
    //   summary: 'A minimal markdown editor.',
    //   tags: ['Flutter', 'appflowye'],
    //   links: [
    //     ProjectLink(
    //       label: 'Source',
    //       url: 'https://github.com/AbrarShakhi/eddit',
    //       icon: Icons.code_rounded,
    //     ),
    //     ProjectLink(
    //       label: 'Download',
    //       url: 'https://example.com/app.apk',
    //       icon: Icons.download_rounded,
    //     ),
    //   ],
    // ),
    Project(
      title: 'Banglish',
      year: '2024',
      summary: 'Linux shell',
      tags: ['C', 'CLI', 'shell', 'linux'],
      links: [
        ProjectLink(
          label: 'Source',
          url: 'https://github.com/AbrarShakhi/banglish',
          icon: Icons.code_rounded,
          isPrimary: true,
        ),
      ],
    ),
    Project(
      title: 'quick-run-in-terminal',
      year: '2024',
      summary: 'VS Code extension to run code across many languages',
      tags: ['vscode', 'javascript', 'node'],
      links: [
        ProjectLink(
          label: 'Source',
          url: 'https://github.com/AbrarShakhi/quick-run-in-terminal',
          icon: Icons.article_outlined,
          isPrimary: true,
        ),
        ProjectLink(
          label: 'Vscode Marketplace',
          url:
              'https://marketplace.visualstudio.com/items?itemName=AbrarShakhi.quick-run-in-terminal',
          icon: Icons.download_outlined,
        ),
      ],
    ),
  ],

  // ----------------------------------------------------------------------- //
  //  EXPERIENCE — work history, newest first.
  // ----------------------------------------------------------------------- //
  experiences: [],

  // ----------------------------------------------------------------------- //
  //  EDUCATION — newest first.
  // ----------------------------------------------------------------------- //
  education: [
    Education(
      degree: 'B.Sc. in Computer Science & Engineering',
      institution: 'Example University',
      period: '2018 — 2022',
      location: 'Dhaka, BD',
      summary: 'Graduated with honours. Focus on distributed systems and HCI.',
    ),
    Education(
      degree: 'Higher Secondary Certificate',
      institution: 'Example College',
      period: '2016 — 2018',
      summary: 'Science track. President of the programming club.',
    ),
  ],

  // ----------------------------------------------------------------------- //
  //  RESEARCH — leave empty `[]` to hide this section.
  // ----------------------------------------------------------------------- //
  research: [],

  // ----------------------------------------------------------------------- //
  //  SKILLS — grouped chips. Leave empty `[]` to hide this section.
  // ----------------------------------------------------------------------- //
  skillGroups: [
    SkillGroup(
      category: 'Languages',
      skills: ['C/C++', 'Kotlin/java', 'python', 'dart', 'typescript'],
    ),
    SkillGroup(
      category: 'Machine Learning',
      skills: ['numpy', 'Pandas', 'openCV', 'sk-learn', 'pytorch'],
    ),
    SkillGroup(category: 'Frameworks', skills: ['Flutter', 'Jetpack-Compose']),
    SkillGroup(
      category: 'Infrastructure',
      skills: ['PostgreSQL', 'Docker', 'Redis', 'Hadoop'],
    ),
  ],
);
