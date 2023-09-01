package com.example.natifetestapp

import com.google.gson.annotations.SerializedName

data class GiphyResponse(
    @SerializedName("data")
    val data: List<GifItem>
)

data class GifItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: Images
)

data class Images(
    @SerializedName("original")
    val original: ImageDetails
)

data class ImageDetails(
    @SerializedName("url")
    val url: String
)