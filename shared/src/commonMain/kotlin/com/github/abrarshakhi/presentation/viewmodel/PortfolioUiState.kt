package com.github.abrarshakhi.presentation.viewmodel

import com.github.abrarshakhi.domain.model.Portfolio

sealed interface PortfolioUiState {
    data object Loading : PortfolioUiState
    data class Success(val portfolio: Portfolio) : PortfolioUiState
    data class Error(val message: String) : PortfolioUiState
}
