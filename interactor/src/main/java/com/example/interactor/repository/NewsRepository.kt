package com.example.interactor.repository

interface NewsRepository {
    suspend fun getNews()
}