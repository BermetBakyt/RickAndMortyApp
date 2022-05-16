package com.example.data.remote.pagingsources

import com.example.data.remote.dto.episode.EpisodeDto
import com.example.data.remote.dto.episode.toEpisode
import com.example.data.remote.dto.location.LocationDto
import com.example.data.remote.dto.location.toLocation
import com.example.data.remote.pagingsources.base.BasePagingSource
import com.example.data.remote.services.EpisodeApiService
import com.example.data.remote.services.LocationApiService
import com.example.domain.models.episode.Episode
import com.example.domain.models.location.Location

class EpisodePagingSource (

    private val service: EpisodeApiService
) : BasePagingSource<EpisodeDto, Episode>(
    { service.fetchEpisodes(it) },
    { data -> data.map { it.toEpisode() } }
)