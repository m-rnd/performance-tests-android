package com.example.finews.datasource.di

import com.example.finews.datasource.NewsDataSource
import com.example.finews.datasource.api.NativeNewsDataSource
import com.example.finews.datasource.api.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatasourceModule {
    @Provides
    @Singleton
    fun provideNewsDataSource(
        flutterNewsService: NewsService
    ): NewsDataSource = NativeNewsDataSource(flutterNewsService)

}