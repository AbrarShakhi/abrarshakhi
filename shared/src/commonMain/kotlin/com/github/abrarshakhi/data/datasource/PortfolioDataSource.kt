package com.github.abrarshakhi.data.datasource

import com.github.abrarshakhi.domain.model.Portfolio

interface PortfolioDataSource {
    suspend fun getPortfolio(): Portfolio
}
