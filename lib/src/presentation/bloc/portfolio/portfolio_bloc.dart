import 'package:equatable/equatable.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../../domain/entities/portfolio.dart';
import '../../../domain/repositories/portfolio_repository.dart';

part 'portfolio_event.dart';
part 'portfolio_state.dart';

class PortfolioBloc extends Bloc<PortfolioEvent, PortfolioState> {
  PortfolioBloc(this._repository) : super(const PortfolioInitial()) {
    on<PortfolioRequested>(_onRequested);
  }

  final PortfolioRepository _repository;

  Future<void> _onRequested(
    PortfolioRequested event,
    Emitter<PortfolioState> emit,
  ) async {
    emit(const PortfolioLoadInProgress());
    try {
      final portfolio = await _repository.getPortfolio();
      emit(PortfolioLoadSuccess(portfolio));
    } catch (error) {
      emit(PortfolioLoadFailure('Could not load portfolio: $error'));
    }
  }
}
