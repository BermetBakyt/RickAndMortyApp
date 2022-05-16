package com.example.rickandmortynew.presentation.models

import com.example.domain.models.episode.Episode
import com.example.rickandmortynew.presentation.base.IBaseDiffModel

data class EpisodeUI (
    override val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: MutableList<String>,
    val url: String,
    val created: String,
) : IBaseDiffModel

fun Episode.toEpisodeUI() = EpisodeUI(
    id,
    name,
    airDate,
    episode,
    characters,
    url,
    created,
)