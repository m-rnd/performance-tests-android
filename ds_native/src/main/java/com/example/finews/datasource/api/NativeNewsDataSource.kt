package com.example.finews.datasource.api

import com.example.entity.datasource.NewsDataSource
import com.example.finews.datasource.api.model.toEntity
import javax.inject.Inject

class NativeNewsDataSource @Inject constructor(
    private val newsService: NewsService
) : NewsDataSource {
    override suspend fun getNews() = callApi(
        call = { newsService.getNews() },
        mapper = {
            it.toEntity()
        }
    )
}