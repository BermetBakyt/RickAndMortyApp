package com.example.data.remote.services

import com.example.data.remote.dto.CharacterPagingResponse
import com.example.data.remote.dto.character.CharacterDto
import com.example.data.remote.dto.episode.EpisodeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("/api/episode/{id}")
    suspend fun fetchEpisode(
        @Path("id") id: Int
    ) : EpisodeDto

    @GET("episode")
    suspend fun fetchEpisodePaging(
        @Query("page") page: Int
    ): Response<CharacterPagingResponse<EpisodeDto>>
}