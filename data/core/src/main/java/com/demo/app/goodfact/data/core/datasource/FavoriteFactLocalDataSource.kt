package com.demo.app.goodfact.data.core.datasource

import com.demo.app.goodfact.data.core.database.dao.FavoriteFactDao
import com.demo.app.goodfact.data.core.database.entity.FavoriteFactEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteFactLocalDataSource @Inject constructor(
    private val dao: FavoriteFactDao
) {
    suspend fun fetchFavorites(): Flow<List<FavoriteFactEntity>> = dao.fetchFavorites()

    suspend fun addFavorite(fact: FavoriteFactEntity) = dao.insert(fact)

    suspend fun removeFavorite(id: String) = dao.removeFavorite(id)
}
