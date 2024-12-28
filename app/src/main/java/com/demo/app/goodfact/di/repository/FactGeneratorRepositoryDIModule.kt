package com.demo.app.goodfact.di.repository

import com.demo.app.goodfact.domain.core.repository.FactGeneratorRepository
import com.demo.app.goodfact.data.core.repository.FactGeneratorRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FactGeneratorRepositoryDIModule {
    @Binds
    abstract fun bindFactGeneratorRepository(impl: FactGeneratorRepositoryImpl): FactGeneratorRepository
}
