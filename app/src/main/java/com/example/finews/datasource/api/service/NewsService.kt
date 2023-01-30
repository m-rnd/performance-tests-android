package com.example.finews.datasource.api.service

import com.example.finews.datasource.api.service.model.ApiNewsEntry
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("news")
    suspend fun getNews(): Response<List<ApiNewsEntry>>
}