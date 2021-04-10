package com.abrahamlay.movielicious.data.mapper

import com.abrahamlay.movielicious.data.dtos.VideoDto
import com.abrahamlay.movielicious.domain.entities.VideoModel


/**
 * Created by Abraham Lay on 14/06/20.
 */

class VideoMapper : Mapper<VideoDto?, List<VideoModel>?>() {
    override fun apply(from: VideoDto?): List<VideoModel>? {
        return from?.results?.map { video ->
            VideoModel(
                video.id,
                video.iso31661,
                video.iso6391,
                video.key,
                video.name,
                video.site,
                video.size,
                video.type
            )
        }
    }
}