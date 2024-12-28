package com.demo.app.goodfact.data.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.app.goodfact.domain.core.model.Fact

@Dao
interface FavoriteFactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(fact: Fact)

    @Query(value = "DELETE FROM FavoriteFact WHERE id=:id")
    fun removeFavorite(id: String)
}
