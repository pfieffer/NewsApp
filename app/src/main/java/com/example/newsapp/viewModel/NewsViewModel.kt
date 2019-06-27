package com.example.newsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.Constants
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.network.NewsRepository

class NewsViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<NewsResponse>
    private val newsRepository: NewsRepository = NewsRepository.instance

    init {
        mutableLiveData = newsRepository.getNews("google-news", Constants.API_KEY)
    }

    fun getNewsRepository() : MutableLiveData<NewsResponse>{
        return mutableLiveData
    }

}