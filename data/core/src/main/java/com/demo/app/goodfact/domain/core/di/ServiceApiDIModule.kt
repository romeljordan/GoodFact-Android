package com.demo.app.goodfact.domain.core.di

import com.demo.app.goodfact.domain.core.api.FactGeneratorServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceApiDIModule {
    @Provides
    @Singleton
    fun provideFactGeneratorApiService(retrofit: Retrofit): FactGeneratorServiceApi =
        retrofit.create(FactGeneratorServiceApi::class.java)
}
