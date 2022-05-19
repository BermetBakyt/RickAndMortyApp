package com.example.data.remote.services

import com.example.data.remote.dto.RickAndMortyResponse
import com.example.data.remote.dto.character.CharacterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character/{id}")
    suspend fun fetchCharacter(@Path("id") id: Int): CharacterDto

    @GET("character")
    suspend fun fetchCharacters(
        @Query("prev") prev: String,
        @Query("next") next: String,
        @Query("page") page: Int = 0
    ): RickAndMortyResponse<CharacterDto>
}