package com.github.abrarshakhi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.abrarshakhi.domain.usecase.GetPortfolioUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PortfolioViewModel(
    private val getPortfolioUseCase: GetPortfolioUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PortfolioUiState>(PortfolioUiState.Loading)
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    init {
        loadPortfolio()
    }

    fun loadPortfolio() {
        viewModelScope.launch {
            _uiState.value = PortfolioUiState.Loading
            getPortfolioUseCase()
                .onSuccess { portfolio ->
                    _uiState.value = PortfolioUiState.Success(portfolio)
                }
                .onFailure { error ->
                    _uiState.value = PortfolioUiState.Error(
                        error.message ?: "Failed to load portfolio content."
                    )
                }
        }
    }

    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }

    fun setTheme(dark: Boolean) {
        _isDarkTheme.value = dark
    }
}
