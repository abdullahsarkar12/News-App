package com.example.newspaper.reposorities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newspaper.viewmodels.NewsViewModel

class NewsViewModelProviderFactory(
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}