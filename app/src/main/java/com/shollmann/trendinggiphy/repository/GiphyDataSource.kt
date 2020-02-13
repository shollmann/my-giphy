package com.shollmann.trendinggiphy.repository

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.shollmann.trendinggiphy.model.Trending
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GiphyDataSource {
    private const val NETWORK_TIMEOUT: Long = 30

    private var retrofit = initRetrofit()
    private var giphyService: GiphyService

    init {
        retrofit = initRetrofit()
        giphyService = retrofit.create(GiphyService::class.java)
    }

    private fun initRetrofit(): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()

        okHttpBuilder
                .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)

        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        return Retrofit.Builder()
                .baseUrl("https://api.giphy.com/")
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    fun getTrending(): Response<Trending> {
        return giphyService.getTrending().execute()
    }

}
