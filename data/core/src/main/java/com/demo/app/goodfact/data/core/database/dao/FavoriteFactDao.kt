package com.demo.app.goodfact.data.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.app.goodfact.data.core.database.entity.FavoriteFactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteFactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(fact: FavoriteFactEntity)

    @Query(value = "DELETE FROM FavoriteFact WHERE id=:id")
    fun removeFavorite(id: String): Int

    @Query(value = "SELECT * FROM FavoriteFact")
    fun fetchFavorites(): Flow<List<FavoriteFactEntity>>
}
