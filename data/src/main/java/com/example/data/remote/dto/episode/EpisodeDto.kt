package com.example.data.remote.dto.episode

import com.example.domain.models.episode.Episode
import com.google.gson.annotations.SerializedName

class EpisodeDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("characters")
    val characters: MutableList<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)

fun EpisodeDto.toEpisode(): Episode {
    return Episode(
        id,
        name,
        airDate,
        episode,
        characters,
        url,
        created
    )
}