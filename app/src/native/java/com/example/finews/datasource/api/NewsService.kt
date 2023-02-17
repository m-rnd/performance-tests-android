package com.example.finews.datasource.api

import com.example.finews.datasource.api.model.ApiNewsEntry
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("news")
    suspend fun getNews(): Response<List<ApiNewsEntry>>
}