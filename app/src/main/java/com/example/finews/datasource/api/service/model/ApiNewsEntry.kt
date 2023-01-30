package com.example.finews.datasource.api.service.model

import com.example.entity.NewsEntry
import com.example.finews.datasource.api.service.mappingError

data class ApiNewsEntry(
    val title: String?
): ApiEntity<NewsEntry> {
    override fun toEntity() = when {
        title == null -> mappingError(::title)
        else -> NewsEntry(title)
    }
}