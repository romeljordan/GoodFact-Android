package com.demo.app.goodfact.data.core.di

import com.demo.app.goodfact.data.core.database.GoodFactDatabase
import com.demo.app.goodfact.data.core.database.dao.FavoriteFactDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoDIModule {
    @Provides
    @Singleton
    fun provideFavoriteFactDao(database: GoodFactDatabase): FavoriteFactDao =
        database.favoriteFactDao()
}
