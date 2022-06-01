package com.example.domain.use_cases

import com.example.domain.repository.CharacterRepository

class FetchCharacterByIdUseCase (
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(id: Int) = characterRepository.fetchCharacter(id)
}