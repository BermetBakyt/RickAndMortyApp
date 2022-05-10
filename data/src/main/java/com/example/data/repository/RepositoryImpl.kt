package com.example.data.repository

import com.example.data.remote.dto.toCharacter
import com.example.data.remote.services.CharacterServiceApi
import com.example.domain.repository.CharacterRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: CharacterServiceApi
) : BaseRepository(), CharacterRepository {

    override fun fetchCharacters() = doRequest {
        service.fetchAllCharacters().results.map { it.toCharacter() }
    }

    override fun fetchCharacter(id: Int) = doRequest {
        service.fetchCharacter(id).toCharacter()
    }
}