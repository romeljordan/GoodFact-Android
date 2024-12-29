package com.demo.app.goodfact.domain.core.usecase

import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.domain.core.repository.FactGeneratorRepository
import javax.inject.Inject

interface FactGeneratorUseCase {
    suspend fun generateRandomFact(): Result<Fact>
    suspend fun generateDailyFact(): Result<Fact>
}

final class FactGeneratorUseCaseImpl @Inject constructor(
    private val repository: FactGeneratorRepository
): FactGeneratorUseCase {
    override suspend fun generateRandomFact(): Result<Fact> {
        return try { // TODO: create generic function to handle result from API call
            return Result.success(
                repository.generateRandomFact()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun generateDailyFact(): Result<Fact> {
        return try {
            return Result.success(
                repository.generateDailyFact()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
