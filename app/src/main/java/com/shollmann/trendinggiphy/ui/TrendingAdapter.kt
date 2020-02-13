package com.shollmann.trendinggiphy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shollmann.trendinggiphy.databinding.GifViewholderBinding
import com.shollmann.trendinggiphy.model.Gif

class TrendingAdapter : ListAdapter<Gif, TrendingAdapter.ViewHolder>(GifDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: GifViewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(gif: Gif) {
            Glide.with(binding.image.context).load(gif.images.original.url)
                .centerCrop()
                .into(binding.image);
            binding.gif = gif
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GifViewholderBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    class GifDiffCallback : DiffUtil.ItemCallback<Gif>() {
        override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean {
            return oldItem == newItem
        }
    }
}
