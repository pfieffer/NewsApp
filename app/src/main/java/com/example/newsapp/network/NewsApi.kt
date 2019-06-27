package com.example.newsapp.network

import com.example.newsapp.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getNewsList(
        @Query("sources") newsSource: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>

}