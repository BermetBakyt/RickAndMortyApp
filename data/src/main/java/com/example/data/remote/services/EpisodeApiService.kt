package com.example.data.remote.services

import com.example.data.remote.dto.episode.EpisodeDto
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiService {

    @GET("/api/episode/{id}")
    suspend fun fetchEpisode(
        @Path("id") id: Int
    ) : EpisodeDto
}