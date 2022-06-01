package com.example.data.repository

import com.example.data.remote.dto.character.toCharacter
import com.example.data.remote.pagingsources.CharacterPagingSource
import com.example.data.remote.services.CharacterApiService
import com.example.data.repository.base.BaseRepository
import com.example.domain.repository.CharacterRepository

class CharacterRepositoryImpl (
    private val service: CharacterApiService
) : BaseRepository(), CharacterRepository {

    fun fetchCharactersPaging() = doPagingRequest(CharacterPagingSource(service))

    override fun fetchCharacter(id: Int) = doRequest {
        service.fetchCharacter(id).toCharacter()
    }
}