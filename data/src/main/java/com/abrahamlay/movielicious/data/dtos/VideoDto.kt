package com.abrahamlay.movielicious.data.dtos


import com.abrahamlay.movielicious.data.dtos.ResultVideo
import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<ResultVideo>?
)