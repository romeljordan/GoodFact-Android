package com.demo.app.goodfact.data.core.repository

import com.demo.app.goodfact.data.core.datasource.FavoriteFactLocalDataSource
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.domain.core.repository.FavoriteFactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

final class FavoriteFactRepositoryImpl @Inject constructor(
    private val dataSource: FavoriteFactLocalDataSource
) : FavoriteFactRepository {
    override suspend fun fetchFavorites(): Flow<List<Fact>> {
        return dataSource.fetchFavorites()
    }

    override suspend fun addFavorite(fact: Fact): Boolean {
        return try {
            dataSource.addFavorite(fact)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun removeFavorite(id: String): Boolean {
        return try {
            dataSource.removeFavorite(id)
            true
        } catch (e: Exception) {
            false
        }
    }
}