package com.demo.app.goodfact.domain.core.usecase

import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.domain.core.repository.FavoriteFactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FavoriteFactUseCase {
    suspend fun fetchFavorites(): Flow<List<Fact>>
    suspend fun addFavorite(fact: Fact): Result<Boolean>
    suspend fun removeFavorite(id: String): Result<Boolean>
}

final class FavoriteFactUseCaseImpl @Inject constructor(
    private val repository: FavoriteFactRepository
) : FavoriteFactUseCase {
    override suspend fun fetchFavorites(): Flow<List<Fact>> {
        return repository.fetchFavorites()
    }

    override suspend fun addFavorite(fact: Fact): Result<Boolean> {
        val result = repository.addFavorite(fact)
        return when (result) {
            true -> Result.success(true)
            false -> Result.failure(RuntimeException(message = "Failed to add fact to favorites"))
        }
    }

    override suspend fun removeFavorite(id: String): Result<Boolean> {
        val result = repository.removeFavorite(id)
        return when (result) {
            true -> Result.success(true)
            false -> Result.failure(RuntimeException(message = "Failed to remove fact in favorites"))
        }
    }
}
