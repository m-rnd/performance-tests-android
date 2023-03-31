package com.example.finews.datasource.api

import androidx.core.os.trace
import com.example.entity.AppResult
import com.example.entity.NewsEntry
import com.example.entity.common.TraceSection
import com.example.entity.datasource.NewsDataSource
import com.example.traceutil.traceAsync
import javax.inject.Inject

class FlutterNewsDataSource @Inject constructor(
    private val newsService: FlutterNewsService
) : NewsDataSource {
    override suspend fun getNews(): AppResult<List<NewsEntry>> {

        val news = traceAsync(TraceSection.FLUTTER_DS_GET_NEWS.traceName) {
            newsService.getNews()
        }

        val newsEntries = trace(TraceSection.FLUTTER_DS_MAPPING.traceName) {
            news.mapNotNull {
                it.title?.let { title ->
                    NewsEntry(title)
                }
            }
        }

        return AppResult.Success(newsEntries)
    }
}
