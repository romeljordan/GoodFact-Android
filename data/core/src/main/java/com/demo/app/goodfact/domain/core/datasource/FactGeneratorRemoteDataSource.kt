package com.demo.app.goodfact.domain.core.datasource

import com.demo.app.goodfact.domain.core.dto.FactDto
import retrofit2.Response

final class FactGeneratorRemoteDataSource {
    suspend fun generateRandomFact(): Response<FactDto> {
        TODO("")
    }

    suspend fun generateDailyFact(): Response<FactDto> {
        TODO("")
    }
}
