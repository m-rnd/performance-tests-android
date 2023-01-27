package com.example.interactor.usecase

import com.example.interactor.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke() = newsRepository.getNews()
}