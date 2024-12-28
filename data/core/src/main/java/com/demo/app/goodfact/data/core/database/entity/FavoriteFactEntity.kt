package com.demo.app.goodfact.data.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteFact")
data class FavoriteFactEntity(
    @PrimaryKey
    val id: String,
    val content: String,
    val source: String
)
