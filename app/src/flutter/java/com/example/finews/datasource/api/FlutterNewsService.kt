package com.example.finews.datasource.api


interface FlutterNewsService {

    suspend fun getNews(): List<FlutterApiNewsEntity>
}