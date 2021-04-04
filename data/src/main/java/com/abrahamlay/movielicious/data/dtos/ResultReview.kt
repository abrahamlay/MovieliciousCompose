package com.abrahamlay.data.dtos


import com.google.gson.annotations.SerializedName

data class ResultReview(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?
)