part of 'portfolio_bloc.dart';

sealed class PortfolioState extends Equatable {
  const PortfolioState();

  @override
  List<Object?> get props => [];
}

final class PortfolioInitial extends PortfolioState {
  const PortfolioInitial();
}

final class PortfolioLoadInProgress extends PortfolioState {
  const PortfolioLoadInProgress();
}

final class PortfolioLoadSuccess extends PortfolioState {
  const PortfolioLoadSuccess(this.portfolio);

  final Portfolio portfolio;

  @override
  List<Object?> get props => [portfolio];
}

final class PortfolioLoadFailure extends PortfolioState {
  const PortfolioLoadFailure(this.message);

  final String message;

  @override
  List<Object?> get props => [message];
}
