package com.example.data.remote.services

import com.example.data.remote.dto.CharacterPagingResponse
import com.example.data.remote.dto.character.CharacterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("character/{id}")
    suspend fun fetchCharacter(@Path("id") id: Int): CharacterDto

    @GET("character")
    suspend fun fetchCharactersPaging(
        @Query("page") page: Int
    ): Response<CharacterPagingResponse<CharacterDto>>
}