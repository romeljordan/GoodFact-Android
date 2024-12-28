package com.demo.app.goodfact.data.core.api

import com.demo.app.goodfact.data.core.dto.FactDto
import retrofit2.Response
import retrofit2.http.GET


interface FactGeneratorServiceApi {
    @GET("api/v2/facts/random")
    suspend fun getRandomFact(): Response<FactDto>

    @GET("api/v2/facts/today")
    suspend fun getDailyFact(): Response<FactDto>
}
