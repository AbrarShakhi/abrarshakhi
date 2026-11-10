package com.github.abrarshakhi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.github.abrarshakhi.core.theme.AppTheme
import com.github.abrarshakhi.data.datasource.PortfolioLocalDataSource
import com.github.abrarshakhi.data.repository.PortfolioRepositoryImpl
import com.github.abrarshakhi.domain.usecase.GetPortfolioUseCase
import com.github.abrarshakhi.presentation.PortfolioScreen
import com.github.abrarshakhi.presentation.viewmodel.PortfolioViewModel

@Composable
fun App() {
    val viewModel = remember {
        val dataSource = PortfolioLocalDataSource()
        val repository = PortfolioRepositoryImpl(dataSource)
        val useCase = GetPortfolioUseCase(repository)
        PortfolioViewModel(useCase)
    }

    val isDarkTheme by viewModel.isDarkTheme.collectAsState()

    AppTheme(darkTheme = isDarkTheme) {
        PortfolioScreen(viewModel = viewModel)
    }
}
