package com.example.finews.datasource.di

import com.example.entity.datasource.NewsDataSource
import com.example.finews.datasource.api.FlutterNewsDataSource
import com.example.finews.datasource.api.FlutterNewsService
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
        flutterNewsService: FlutterNewsService
    ): NewsDataSource = FlutterNewsDataSource(flutterNewsService)

}