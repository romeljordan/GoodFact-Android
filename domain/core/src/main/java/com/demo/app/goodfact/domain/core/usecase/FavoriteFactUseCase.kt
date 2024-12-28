package com.demo.app.goodfact.domain.core.usecase

import com.demo.app.goodfact.domain.core.model.Fact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FavoriteFactUseCase {
    suspend fun fetchFavorites(): Flow<List<Fact>>
    suspend fun addFavorite(fact: Fact): Result<Boolean>
    suspend fun removeFavorite(fact: Fact): Result<Boolean>
}

final class FavoriteFactUseCaseImpl @Inject constructor(

) : FavoriteFactUseCase {
    override suspend fun fetchFavorites(): Flow<List<Fact>> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(fact: Fact): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavorite(fact: Fact): Result<Boolean> {
        TODO("Not yet implemented")
    }
}
