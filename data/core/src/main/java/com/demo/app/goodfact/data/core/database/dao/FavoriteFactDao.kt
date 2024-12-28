package com.demo.app.goodfact.data.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.app.goodfact.domain.core.model.Fact
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteFactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(fact: Fact)

    @Query(value = "DELETE FROM FavoriteFact WHERE id=:id")
    suspend fun removeFavorite(id: String)

    @Query(value = "SELECT * FROM FavoriteFact")
    suspend fun fetchFavorites(): Flow<List<Fact>>
}
