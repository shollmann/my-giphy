package com.shollmann.trendinggiphy.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shollmann.trendinggiphy.model.Gif
import com.shollmann.trendinggiphy.model.Trending
import com.shollmann.trendinggiphy.repository.GiphyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal class TrendingViewModel : ViewModel() {
    val trendingList = MutableLiveData<List<Gif>>()

    fun loadTrending() = GlobalScope.launch(Dispatchers.Main) {
        val serviceResponse = GiphyRepository.getTrending()

        launch(Dispatchers.Main) {
            trendingList.value = (serviceResponse.response as Trending).data
        }
    }
}
