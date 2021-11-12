package com.example.deutschenachrichten.data.remote

import android.database.Observable
import com.example.deutschenachrichten.data.model.NewsResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("news")
    suspend fun getNews(
        @Query("q") city: String,
        @Query("appid") api_key: String
    ): Response<NewsResponse>
}