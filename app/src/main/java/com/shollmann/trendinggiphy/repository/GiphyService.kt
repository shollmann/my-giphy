package com.shollmann.trendinggiphy.repository

import com.shollmann.trendinggiphy.model.Trending
import retrofit2.Call
import retrofit2.http.GET

interface GiphyService {
    @GET("stickers/trending")
    fun getTrending(): Call<Trending>
}
