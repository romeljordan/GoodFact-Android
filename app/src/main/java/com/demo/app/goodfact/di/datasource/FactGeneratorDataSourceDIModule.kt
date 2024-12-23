package com.demo.app.goodfact.di.datasource

import com.demo.app.goodfact.domain.core.api.FactGeneratorServiceApi
import com.demo.app.goodfact.domain.core.datasource.FactGeneratorRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FactGeneratorDataSourceDIModule {
    @Provides
    @Singleton
    fun provideFactGeneratorDataSource(apiService: FactGeneratorServiceApi): FactGeneratorRemoteDataSource =
        FactGeneratorRemoteDataSource(apiService = apiService)
}
