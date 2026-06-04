import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../core/theme/app_spacing.dart';
import '../../domain/entities/portfolio.dart';
import '../bloc/portfolio/portfolio_bloc.dart';
import '../bloc/theme/theme_cubit.dart';

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
  @override
  void dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        Positioned.fill(
          child: SingleChildScrollView(child: Column(children: [])),
        ),
      ],
    );
  }
}
