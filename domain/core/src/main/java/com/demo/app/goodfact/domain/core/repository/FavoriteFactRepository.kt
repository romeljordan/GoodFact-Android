package com.demo.app.goodfact.domain.core.repository

import com.demo.app.goodfact.domain.core.model.Fact
import kotlinx.coroutines.flow.Flow

interface FavoriteFactRepository {
    suspend fun fetchFavorites(): Flow<List<Fact>>
    suspend fun addFavorite(fact: Fact): Boolean
    suspend fun removeFavorite(id: String): Boolean
}
