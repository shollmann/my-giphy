package com.shollmann.trendinggiphy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shollmann.trendinggiphy.R
import com.shollmann.trendinggiphy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: TrendingAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this)[TrendingViewModel::class.java]

        binding.viewModel = viewModel
        setupListAdapter()

        viewModel.trendingList.observe(this, Observer { listAdapter.submitList(it)})

        viewModel.loadTrending()



    }

    private fun setupListAdapter() {
        listAdapter = TrendingAdapter()
        binding.recyclerview.adapter = listAdapter
    }
}
