package com.demo.app.goodfact.data.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.app.goodfact.data.core.database.converter.FactTypeConverter
import com.demo.app.goodfact.data.core.database.dao.FavoriteFactDao
import com.demo.app.goodfact.data.core.database.entity.FavoriteFactEntity

@Database(
    version = 1,
    entities = [
        FavoriteFactEntity::class
    ]
)
@TypeConverters(FactTypeConverter::class)
abstract class GoodFactDatabase : RoomDatabase() {
    abstract fun favoriteFactDao(): FavoriteFactDao

    companion object {
        @Volatile
        private var instance: GoodFactDatabase? = null

        fun getInstance(context: Context): GoodFactDatabase {
            return instance ?: run {
                Room.databaseBuilder(
                    context,
                    GoodFactDatabase::class.java,
                    "goodfact-database"
                ).build().also {
                    instance = it
                }
            }
        }
    }
}
