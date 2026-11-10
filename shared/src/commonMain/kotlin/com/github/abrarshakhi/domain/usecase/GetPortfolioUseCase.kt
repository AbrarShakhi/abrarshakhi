package com.github.abrarshakhi.domain.usecase

import com.github.abrarshakhi.domain.model.Portfolio
import com.github.abrarshakhi.domain.repository.PortfolioRepository

class GetPortfolioUseCase(
    private val repository: PortfolioRepository
) {
    suspend operator fun invoke(): Result<Portfolio> {
        return repository.getPortfolio()
    }
}
