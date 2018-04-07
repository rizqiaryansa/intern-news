package com.rizqiaryansa.internnews.network


import com.rizqiaryansa.internnews.model.News

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    fun getHeadlines(@Query("sources") sources: String,
                     @Query("apiKey") apiKey: String): Call<News>

    @GET("everything")
    fun getRecents(@Query("sources") sources: String,
                   @Query("apiKey") apiKey: String): Call<News>
}
