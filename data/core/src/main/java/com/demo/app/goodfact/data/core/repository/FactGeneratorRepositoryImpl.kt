package com.demo.app.goodfact.data.core.repository

import com.demo.app.goodfact.data.core.datasource.FactGeneratorRemoteDataSource
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.domain.core.repository.FactGeneratorRepository
import javax.inject.Inject

final class FactGeneratorRepositoryImpl @Inject constructor(
    private val dataSource: FactGeneratorRemoteDataSource
): FactGeneratorRepository {
    override suspend fun generateRandomFact(): Fact {
        val response = dataSource.generateRandomFact()
        return when (response.isSuccessful) { // TODO: create a generic function to parse API response
            true -> response.body()?.toDomainModel() ?: throw NoSuchElementException("Response does not have body")
            false -> throw RuntimeException(response.errorBody()?.string())
        }
    }

    override suspend fun generateDailyFact(): Fact {
        val response = dataSource.generateDailyFact()
        return when (response.isSuccessful) {
            true -> response.body()?.toDomainModel() ?: throw NoSuchElementException("Response does not have body")
            false -> throw RuntimeException(response.errorBody()?.string())
        }
    }
}
