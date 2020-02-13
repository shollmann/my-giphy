package com.shollmann.trendinggiphy.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shollmann.trendinggiphy.model.Gif

@BindingAdapter("app:gifs")
fun setGifs(listView: RecyclerView, items: List<Gif>) {
    (listView.adapter as TrendingAdapter).submitList(items)
}
