package com.example.deutschenachrichten.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.deutschenachrichten.data.repo.NewsRepository
import com.example.deutschenachrichten.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepo: NewsRepository
) : ViewModel() {
    fun fetchNews(api_key: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = newsRepo.getNews(api_key)))
        } catch (exception: Exception) {
            emit(Resource.error(exception.message ?: "Error Occurred!", data = null))
        }
    }
}