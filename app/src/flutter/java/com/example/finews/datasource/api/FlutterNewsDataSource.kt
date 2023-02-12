package com.example.finews.datasource.api

import com.example.entity.AppResult
import com.example.entity.NewsEntry
import com.example.finews.datasource.NewsDataSource
import javax.inject.Inject

class FlutterNewsDataSource @Inject constructor(
    private val newsService: FlutterNewsService
): NewsDataSource {
    override suspend fun getNews(): AppResult<List<NewsEntry>> {
        return AppResult.Success(newsService.getNews().map {
            NewsEntry(it.title!!) //TODO mapping
        })
    }
}
