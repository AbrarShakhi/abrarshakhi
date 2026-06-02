import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'core/theme/app_theme.dart';
import 'data/portfolio_content.dart';
import 'domain/repositories/portfolio_repository.dart';
import 'presentation/bloc/portfolio/portfolio_bloc.dart';
import 'presentation/bloc/theme/theme_cubit.dart';

class PortfolioApp extends StatelessWidget {
  const PortfolioApp({super.key, required this.repository});

  final PortfolioRepository repository;

  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      providers: [
        BlocProvider(create: (_) => ThemeCubit()),
        BlocProvider(
          create: (_) =>
              PortfolioBloc(repository)..add(const PortfolioRequested()),
        ),
      ],
      child: BlocBuilder<ThemeCubit, ThemeMode>(
        builder: (context, themeMode) {
          return MaterialApp(
            title: portfolioContent.profile.name,
            debugShowCheckedModeBanner: false,
            theme: AppTheme.light(),
            darkTheme: AppTheme.dark(),
            themeMode: themeMode,
            home: const Scaffold(),
          );
        },
      ),
    );
  }
}
