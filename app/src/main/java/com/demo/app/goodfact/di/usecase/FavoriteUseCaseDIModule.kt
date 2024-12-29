package com.demo.app.goodfact.di.usecase

import com.demo.app.goodfact.domain.core.usecase.FavoriteFactUseCase
import com.demo.app.goodfact.domain.core.usecase.FavoriteFactUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoriteUseCaseDIModule {
    @Binds
    @Singleton
    abstract fun bindFavoriteFactUseCase(impl: FavoriteFactUseCaseImpl): FavoriteFactUseCase
}
