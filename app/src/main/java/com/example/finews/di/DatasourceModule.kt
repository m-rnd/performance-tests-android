package com.example.finews.di

import com.example.finews.datasource.NewsDataSource
import com.example.finews.datasource.NewsDataSourceImpl
import com.example.finews.datasource.api.service.NewsService
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
        newsService: NewsService
    ): NewsDataSource = NewsDataSourceImpl(newsService)
}