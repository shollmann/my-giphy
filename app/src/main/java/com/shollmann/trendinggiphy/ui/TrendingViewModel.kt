package com.shollmann.trendinggiphy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shollmann.trendinggiphy.model.Gif
import com.shollmann.trendinggiphy.model.Trending
import com.shollmann.trendinggiphy.repository.GiphyRepository
import com.shollmann.trendinggiphy.repository.ResponseCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal class TrendingViewModel : ViewModel() {
    private val items = MutableLiveData<List<Gif>>().apply { value = emptyList() }
    val trendingList: LiveData<List<Gif>> = items

    fun loadTrending() = GlobalScope.launch {
        val serviceResponse = GiphyRepository.getTrending()

        if (serviceResponse.code != ResponseCode.SERVICE_ERROR) {
            launch(Dispatchers.Main) {
                items.value = (serviceResponse.response as Trending).data
            }
        }
    }
}
