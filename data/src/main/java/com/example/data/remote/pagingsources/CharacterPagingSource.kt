package com.example.data.remote.pagingsources

import com.example.data.remote.dto.Info
import com.example.data.remote.dto.RickAndMortyResponse
import com.example.data.remote.dto.character.CharacterDto
import com.example.data.remote.dto.character.toCharacter
import com.example.data.remote.pagingsources.base.BasePagingSource
import com.example.data.remote.services.CharacterApiService
import com.example.domain.models.character.Character
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


class CharacterPagingSource(
    private val service: CharacterApiService
) : BasePagingSource<CharacterDto, Character>(
    { service.fetchCharacters(it) },
    { data -> data.map { it.toCharacter() } }
)