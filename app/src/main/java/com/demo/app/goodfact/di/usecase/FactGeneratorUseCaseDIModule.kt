package com.demo.app.goodfact.di.usecase

import com.demo.app.goodfact.domain.core.usecase.FactGeneratorUseCase
import com.demo.app.goodfact.domain.core.usecase.FactGeneratorUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FactGeneratorUseCaseDIModule {
    @Binds
    abstract fun bindFactGeneratorUseCase(impl: FactGeneratorUseCaseImpl): FactGeneratorUseCase
}
