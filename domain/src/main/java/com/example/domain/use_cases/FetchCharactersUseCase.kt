package com.example.domain.use_cases

import com.example.domain.repository.CharacterRepository

class FetchCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
    ) {
    operator fun invoke() = characterRepository.fetchCharacters()
}