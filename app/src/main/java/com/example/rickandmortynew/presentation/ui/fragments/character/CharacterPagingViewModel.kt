package com.example.rickandmortynew.presentation.ui.fragments.character

import com.example.data.repository.CharacterRepositoryImpl
import com.example.domain.use_cases.FetchEpisodeByIdUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toCharacterUI

class CharacterPagingViewModel (
    private val characterRepository: CharacterRepositoryImpl,
    private val fetchEpisodeByIdUseCase: FetchEpisodeByIdUseCase
) : BaseViewModel() {

    fun fetchCharactersPaging() =
        characterRepository.fetchCharactersPaging().collectPagingRequest { it.toCharacterUI() }

    fun fetchEpisode(id: Int) = fetchEpisodeByIdUseCase(id)
}