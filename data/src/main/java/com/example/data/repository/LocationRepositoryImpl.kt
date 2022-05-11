package com.example.data.repository

import com.example.data.remote.dto.character.toCharacter
import com.example.data.remote.pagingsources.CharacterPagingSource
import com.example.data.remote.services.CharacterApiService
import com.example.data.repository.base.BaseRepository
import com.example.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val service: CharacterApiService
) : BaseRepository(), LocationRepository {

    fun fetchCharactersPaging() = doPagingRequest(CharacterPagingSource(service))

    override fun fetchCharacter(id: Int) = doRequest {
        service.fetchCharacter(id).toCharacter()
    }
}