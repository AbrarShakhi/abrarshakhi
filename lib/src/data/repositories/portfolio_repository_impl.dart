import '../../domain/entities/portfolio.dart';
import '../../domain/repositories/portfolio_repository.dart';
import '../portfolio_content.dart';

class PortfolioRepositoryImpl implements PortfolioRepository {
  const PortfolioRepositoryImpl();

  @override
  Future<Portfolio> getPortfolio() async => portfolioContent;
}
