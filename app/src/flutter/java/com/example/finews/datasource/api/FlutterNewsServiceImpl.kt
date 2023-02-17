package com.example.finews.datasource.api


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FlutterNewsServiceImpl @Inject constructor(
    private val api: FlutterNewsApi
) : FlutterNewsService {

    override suspend fun getNews(): List<FlutterApiNewsEntity> = withContext(Dispatchers.Main) {
        suspendCoroutine { continuation ->
            api.getNews {
                continuation.resume(it)
            }
        }
    }
}