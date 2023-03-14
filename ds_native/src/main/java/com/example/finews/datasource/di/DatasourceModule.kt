package com.example.finews.datasource.di

import com.example.entity.datasource.NewsDataSource
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
        newsService: NewsService
    ): NewsDataSource = NativeNewsDataSource(newsService)

}