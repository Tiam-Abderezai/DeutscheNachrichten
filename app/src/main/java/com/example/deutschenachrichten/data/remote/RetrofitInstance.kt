package com.example.deutschenachrichten.data.remote

import com.example.deutschenachrichten.data.model.NewsResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInstance {
    @GET("news")
    suspend fun getNews(
        @Query("q") url: String,
        @Query("appid") api_key: String
    ): Response<NewsResponse>
}