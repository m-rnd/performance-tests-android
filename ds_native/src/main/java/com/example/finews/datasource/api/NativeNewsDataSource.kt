package com.example.finews.datasource.api

import com.example.entity.common.TraceSection
import com.example.entity.datasource.NewsDataSource
import com.example.finews.datasource.api.model.toEntity
import com.example.traceutil.traceAsync
import javax.inject.Inject

class NativeNewsDataSource @Inject constructor(
    private val newsService: NewsService
) : NewsDataSource {
    override suspend fun getNews() = traceAsync(TraceSection.NATIVE_DS_GET_NEWS.traceName) {
        callApi(
            call = { newsService.getNews() },
            mapper = {
                it.toEntity()
            }
        )
    }
}