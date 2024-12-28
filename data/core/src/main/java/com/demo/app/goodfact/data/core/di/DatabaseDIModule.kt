package com.demo.app.goodfact.data.core.di

import android.content.Context
import com.demo.app.goodfact.data.core.database.GoodFactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseDIModule {
    @Provides
    @Singleton
    fun provideGoodFactDatabase(
        @ApplicationContext context: Context
    ): GoodFactDatabase = GoodFactDatabase.getInstance(context)
}
