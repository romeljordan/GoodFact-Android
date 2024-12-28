package com.demo.app.goodfact.data.core.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDIModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideOkHttpCallFactory(): Call.Factory =
        OkHttpClient.Builder()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(callFactory: Call.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://uselessfacts.jsph.pl/")
            .callFactory(callFactory)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}
