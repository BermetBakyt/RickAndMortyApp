package com.example.data.repository

import com.example.data.remote.dto.episode.toEpisode
import com.example.data.remote.dto.location.toLocation
import com.example.data.remote.pagingsources.EpisodePagingSource
import com.example.data.remote.pagingsources.LocationPagingSource
import com.example.data.remote.services.EpisodeApiService
import com.example.data.remote.services.LocationApiService
import com.example.data.repository.base.BaseRepository
import com.example.domain.Either
import com.example.domain.models.episode.Episode
import com.example.domain.repository.EpisodeRepository
import com.example.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val service: EpisodeApiService
) : BaseRepository(), EpisodeRepository {

    fun fetchEpisodes() = doPagingRequest(EpisodePagingSource(service))

    override fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id).toEpisode()
    }

}