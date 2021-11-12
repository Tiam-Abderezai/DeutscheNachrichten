package com.example.deutschenachrichten.di

import com.example.deutschenachrichten.data.remote.RetrofitInstance
import com.example.deutschenachrichten.data.repo.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object NewsRepoModule {

    @Provides
    fun provideNewsRepo(retrofitInstance: RetrofitInstance): NewsRepository {
        return NewsRepository(retrofitInstance)
    }
}