import 'package:flutter/material.dart';

import 'src/data/repositories/portfolio_repository_impl.dart';
import 'src/app.dart';

void main() {
  runApp(const PortfolioApp(repository: PortfolioRepositoryImpl()));
}
