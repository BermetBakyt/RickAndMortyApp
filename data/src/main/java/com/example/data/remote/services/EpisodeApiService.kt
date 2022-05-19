package com.example.data.remote.services

import com.example.data.remote.dto.RickAndMortyResponse
import com.example.data.remote.dto.episode.EpisodeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("episode/{id}")
    suspend fun fetchEpisode(
        @Path("id") id: Int
    ) : EpisodeDto

    @GET("episode")
    suspend fun fetchEpisodes(
        @Query("prev") prev: String,
        @Query("next") next: String,
        @Query("page") page: Int = 0
    ): RickAndMortyResponse<EpisodeDto>
}