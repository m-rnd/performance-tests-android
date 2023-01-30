package com.example.interactor.repository

import com.example.entity.AppResult
import com.example.entity.NewsEntry

interface NewsRepository {
    suspend fun getNews(): AppResult<List<NewsEntry>>
}