package com.abrahamlay.movielicious.domain.entities


import com.google.gson.annotations.SerializedName

data class VideosModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<VideoModel>?
)