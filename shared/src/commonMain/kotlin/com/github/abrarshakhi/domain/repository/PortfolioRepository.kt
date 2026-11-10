package com.github.abrarshakhi.domain.repository

import com.github.abrarshakhi.domain.model.Portfolio

interface PortfolioRepository {
    suspend fun getPortfolio(): Result<Portfolio>
}
