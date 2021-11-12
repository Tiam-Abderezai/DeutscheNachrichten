package com.example.deutschenachrichten.data.model

import android.os.Parcelable
import com.google.gson.JsonObject
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    ) : Parcelable
