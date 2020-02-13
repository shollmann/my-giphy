package com.shollmann.trendinggiphy.repository

import java.net.UnknownHostException

object GiphyRepository {

    private var remoteDataSource: GiphyDataSource = GiphyDataSource

    fun getTrending(): ServiceResponse {
        try {
            val response = remoteDataSource.getTrending()

            if (response.isSuccessful) {
                return ServiceResponse.buildSuccessful(response.body())
            }

            return ServiceResponse.buildServiceError("Response was not successful")
        } catch (e: UnknownHostException) {
            return ServiceResponse.buildNetworkError(e.message)
        } catch (e: Exception) {
            return ServiceResponse.buildServiceError(e.message)
        }
    }

}
