package com.demo.app.goodfact.domain.core.datasource

import com.demo.app.goodfact.domain.core.api.FactGeneratorServiceApi
import com.demo.app.goodfact.domain.core.dto.FactDto
import retrofit2.Response
import javax.inject.Inject

final class FactGeneratorRemoteDataSource @Inject constructor(
    private val apiService: FactGeneratorServiceApi
) {
    suspend fun generateRandomFact(): Response<FactDto> = apiService.getRandomFact()

    suspend fun generateDailyFact(): Response<FactDto> = apiService.getDailyFact()
}
