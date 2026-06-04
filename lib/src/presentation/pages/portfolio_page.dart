import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../domain/entities/portfolio.dart';
import '../bloc/portfolio/portfolio_bloc.dart';
import '../bloc/theme/theme_cubit.dart';
import '../widgets/top_nav_bar.dart';

class PortfolioPage extends StatelessWidget {
  const PortfolioPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: BlocBuilder<PortfolioBloc, PortfolioState>(
        builder: (context, state) {
          return switch (state) {
            PortfolioLoadSuccess(:final portfolio) => _PortfolioView(
              portfolio: portfolio,
            ),
            PortfolioLoadFailure(:final message) => _Centered(
              child: Text(message),
            ),
            _ => const _Centered(child: CircularProgressIndicator()),
          };
        },
      ),
    );
  }
}

class _Centered extends StatelessWidget {
  const _Centered({required this.child});
  final Widget child;

  @override
  Widget build(BuildContext context) => Center(child: child);
}

class _PortfolioView extends StatefulWidget {
  const _PortfolioView({required this.portfolio});

  final Portfolio portfolio;

  @override
  State<_PortfolioView> createState() => _PortfolioViewState();
}

class _PortfolioViewState extends State<_PortfolioView> {
  final _scrollController = ScrollController();
  final _aboutKey = GlobalKey();
  final _workKey = GlobalKey();
  final _experienceKey = GlobalKey();
  final _contactKey = GlobalKey();

  @override
  void dispose() {
    _scrollController.dispose();
    super.dispose();
  }

  void _scrollToTop() {
    _scrollController.animateTo(
      0,
      duration: const Duration(milliseconds: 600),
      curve: Curves.easeInOutCubic,
    );
  }

  void _scrollTo(GlobalKey key) {
    final targetContext = key.currentContext;
    if (targetContext == null) return;
    Scrollable.ensureVisible(
      targetContext,
      duration: const Duration(milliseconds: 600),
      curve: Curves.easeInOutCubic,
      alignment: 0.0,
    );
  }

  @override
  Widget build(BuildContext context) {
    final portfolio = widget.portfolio;
    final profile = portfolio.profile;

    final navItems = <NavItem>[
      if (profile.about.isNotEmpty)
        NavItem('About', () => _scrollTo(_aboutKey)),
      if (portfolio.projects.isNotEmpty)
        NavItem('Work', () => _scrollTo(_workKey)),
      if (portfolio.experiences.isNotEmpty)
        NavItem('Experience', () => _scrollTo(_experienceKey)),
    ];

    return Stack(
      children: [
        Positioned.fill(
          child: SingleChildScrollView(
            controller: _scrollController,
            child: Column(children: []),
          ),
        ),
        Positioned(
          top: 0,
          left: 0,
          right: 0,
          child: TopNavBar(
            name: profile.name,
            items: navItems,
            onLogoTap: _scrollToTop,
            isDark: context.watch<ThemeCubit>().isDark,
            onToggleTheme: () => context.read<ThemeCubit>().toggle(),
            onContact: () => _scrollTo(_contactKey),
          ),
        ),
      ],
    );
  }
}
