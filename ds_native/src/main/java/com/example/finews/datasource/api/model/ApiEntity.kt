package com.example.finews.datasource.api.model

interface ApiEntity<T> {
    fun toEntity(): T?
}
fun <T> List<ApiEntity<T>>.toEntity() = this.mapNotNull { it.toEntity() }