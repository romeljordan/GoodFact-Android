package com.demo.app.goodfact.di.repository

import com.demo.app.goodfact.data.core.datasource.FavoriteFactLocalDataSource
import com.demo.app.goodfact.data.core.repository.FavoriteFactRepositoryImpl
import com.demo.app.goodfact.domain.core.repository.FavoriteFactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoriteFactRepositoryDIModule {
    @Binds
    @Singleton
    abstract fun bindsFavoriteFactRepository(impl: FavoriteFactRepositoryImpl): FavoriteFactRepository
}
