package com.example.deutschenachrichten.data.remote

import com.example.deutschenachrichten.data.model.NewsResponse
import com.example.deutschenachrichten.utils.Constants

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInstance {
    @GET("top-headlines?country=de")
    suspend fun getNews(
//        @Query("q") url: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>
}