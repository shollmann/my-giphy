package com.shollmann.trendinggiphy.model

data class Gif(val title: String, val url: String, val id: String, val images: Images)

data class Images(val original: Image)

data class Image(val url: String)
