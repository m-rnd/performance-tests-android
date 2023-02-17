package com.example.entity.datasource

import com.example.entity.AppResult
import com.example.entity.NewsEntry

interface NewsDataSource {
    suspend fun getNews(): AppResult<List<NewsEntry>>
}