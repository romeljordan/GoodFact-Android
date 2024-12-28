package com.demo.app.goodfact.data.core.datasource

import com.demo.app.goodfact.data.core.database.dao.FavoriteFactDao
import com.demo.app.goodfact.domain.core.model.Fact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

final class FavoriteFactLocalDataSource @Inject constructor(
    private val dao: FavoriteFactDao
) {
    suspend fun fetchFavorites(): Flow<List<Fact>> = dao.fetchFavorites()

    suspend fun addFavorite(fact: Fact) = dao.insert(fact)

    suspend fun removeFavorite(id: String) = dao.removeFavorite(id)
}
