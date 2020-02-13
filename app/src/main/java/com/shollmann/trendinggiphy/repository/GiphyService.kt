package com.shollmann.trendinggiphy.repository

import com.shollmann.trendinggiphy.model.Trending
import retrofit2.Call
import retrofit2.http.GET

interface GiphyService {
    //FIXME API key shouldn't be here
    @GET("v1/stickers/trending?api_key=s6kESXvXDrWQXwrXHs6pvChjWvAZXJmn")
    fun getTrending(): Call<Trending>
}
