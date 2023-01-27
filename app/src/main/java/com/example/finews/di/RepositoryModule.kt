package com.example.finews.di

import com.example.finews.repository.NewsRepositoryImpl
import com.example.interactor.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(

    ): NewsRepository = NewsRepositoryImpl()
}