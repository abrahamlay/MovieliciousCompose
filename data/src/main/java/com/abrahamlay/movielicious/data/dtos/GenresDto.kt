package com.abrahamlay.data.dtos


import com.google.gson.annotations.SerializedName

/**
 * Created by Abraham Lay on 2020-06-09.
 */

data class GenresDto(
    @SerializedName("genres")
    val genres: List<Genre>?
)