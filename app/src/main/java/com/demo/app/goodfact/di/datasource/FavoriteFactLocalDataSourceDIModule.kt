package com.demo.app.goodfact.di.datasource

import com.demo.app.goodfact.data.core.database.dao.FavoriteFactDao
import com.demo.app.goodfact.data.core.datasource.FavoriteFactLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteFactLocalDataSourceDIModule {
    @Provides
    @Singleton
    fun provideFavoriteFact(dao: FavoriteFactDao): FavoriteFactLocalDataSource =
        FavoriteFactLocalDataSource(dao)
}
