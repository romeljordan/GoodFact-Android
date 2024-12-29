package com.demo.app.goodfact.data.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demo.app.goodfact.domain.core.model.Fact

@Entity(tableName = "FavoriteFact")
data class FavoriteFactEntity(
    @PrimaryKey
    val id: String,
    val content: String,
    val source: String
) {
    fun toDomainModel() = Fact(id = id, content = content, source = source)
}

fun Fact.toEntity() = FavoriteFactEntity(id = id, content = content, source = source)
