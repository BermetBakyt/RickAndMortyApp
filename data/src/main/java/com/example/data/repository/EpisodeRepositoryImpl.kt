package com.example.data.repository

import com.example.data.remote.dto.episode.toEpisode
import com.example.data.remote.pagingsources.EpisodePagingSource
import com.example.data.remote.services.EpisodeApiService
import com.example.data.repository.base.BaseRepository
import com.example.domain.repository.EpisodeRepository


class EpisodeRepositoryImpl (
    private val service: EpisodeApiService
) : BaseRepository(), EpisodeRepository {

    fun fetchEpisodes() = doPagingRequest(EpisodePagingSource(service))

    override fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id).toEpisode()
    }

}