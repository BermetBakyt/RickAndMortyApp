package com.example.data.remote.services

import com.example.data.remote.dto.CharacterDto
import com.example.data.remote.dto.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterServiceApi {
    @GET("character/{id}")
    suspend fun fetchCharacter(@Path("id") id: Int): CharacterDto

    @GET("character")
    suspend fun fetchAllCharacters(): RickAndMortyResponse<CharacterDto>
}