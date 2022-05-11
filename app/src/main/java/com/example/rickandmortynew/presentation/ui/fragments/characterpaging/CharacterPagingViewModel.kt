package com.example.rickandmortynew.presentation.ui.fragments.characterpaging

import com.example.data.repository.CharacterRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.ui.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterPagingViewModel @Inject constructor(
    private val characterRepository: CharacterRepositoryImpl,
    private val episodeRepository:
) : BaseViewModel() {

    fun fetchCharactersPaging() = repository.fetchCharactersPaging().collectPagingRequest { it.toUI() }

    fun fetchEpisode(id: Int) = fetchEpisodeUseCase(id)
}