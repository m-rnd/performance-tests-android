package com.example.finews.repository

import com.example.entity.datasource.NewsDataSource
import com.example.interactor.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource
): NewsRepository {
    override suspend fun getNews() = newsDataSource.getNews()
}