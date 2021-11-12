package com.example.deutschenachrichten.di

import com.example.deutschenachrichten.data.remote.ApiService
import com.example.deutschenachrichten.data.repo.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object NewsRepoModule {

    @Provides
    fun provideNewsRepo(apiService: ApiService): NewsRepository {
        return NewsRepository(apiService)
    }
}