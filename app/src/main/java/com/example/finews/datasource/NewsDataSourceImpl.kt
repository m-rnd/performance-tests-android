package com.example.finews.datasource

import com.example.finews.datasource.api.service.NewsService
import com.example.finews.datasource.api.service.callApi
import com.example.finews.datasource.api.service.model.toEntity
import javax.inject.Inject

class NewsDataSourceImpl@Inject constructor(
    private val newsService: NewsService
) :  NewsDataSource  {
    override suspend fun getNews() = callApi(
       call = { newsService.getNews() },
        mapper = {
            it.toEntity()
        }
    )
}