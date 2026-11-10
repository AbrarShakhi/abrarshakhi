package com.github.abrarshakhi.data.repository

import com.github.abrarshakhi.data.datasource.PortfolioDataSource
import com.github.abrarshakhi.domain.model.Portfolio
import com.github.abrarshakhi.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl(
    private val localDataSource: PortfolioDataSource
) : PortfolioRepository {

    override suspend fun getPortfolio(): Result<Portfolio> {
        return try {
            val portfolio = localDataSource.getPortfolio()
            Result.success(portfolio)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
