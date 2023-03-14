package com.example.finews.repository

import com.example.entity.common.TraceSection
import com.example.entity.datasource.NewsDataSource
import com.example.interactor.repository.NewsRepository
import com.example.traceutil.traceAsync
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource
) : NewsRepository {
    override suspend fun getNews() = traceAsync(TraceSection.REPOSITORY_GET_NEWS.traceName) {
        newsDataSource.getNews()
    }
}