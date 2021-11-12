package com.example.deutschenachrichten.data.repo

import com.example.deutschenachrichten.data.remote.ApiService
import com.example.deutschenachrichten.data.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNews(url: String, api_key: String): Response<NewsResponse> {
        return apiService.getNews(url, api_key)
    }
}