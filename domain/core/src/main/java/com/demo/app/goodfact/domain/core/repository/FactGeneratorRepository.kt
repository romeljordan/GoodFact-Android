package com.demo.app.goodfact.domain.core.repository

import com.demo.app.goodfact.domain.core.model.Fact

interface FactGeneratorRepository {
    suspend fun generateRandomFact(): Fact
    suspend fun generateDailyFact(): Fact
}
