package com.example.deutschenachrichten.data.repo

import android.util.Log
import com.example.deutschenachrichten.data.remote.RetrofitInstance
import com.example.deutschenachrichten.data.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val retrofitInstance: RetrofitInstance) {
    private val TAG = "NewsRepository"
    suspend fun getNews(api_key: String): Response<NewsResponse> {
        Log.d(TAG, "getNews: $retrofitInstance.getNews(api_key)")
        return retrofitInstance.getNews(api_key)
    }
}