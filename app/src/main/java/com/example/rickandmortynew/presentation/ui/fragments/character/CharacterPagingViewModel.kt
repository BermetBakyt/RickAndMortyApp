package com.example.rickandmortynew.presentation.ui.fragments.character

import com.example.data.repository.CharacterRepositoryImpl
import com.example.data.repository.EpisodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.domain.use_cases.FetchEpisodeByIdUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toCharacterUI
import com.example.rickandmortynew.presentation.models.toEpisodeUI
import com.example.rickandmortynew.presentation.models.toLocationUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterPagingViewModel @Inject constructor(
    private val characterRepository: CharacterRepositoryImpl,
    private val fetchEpisodeByIdUseCase: FetchEpisodeByIdUseCase
) : BaseViewModel() {

    fun fetchCharactersPaging() =
        characterRepository.fetchCharactersPaging().collectPagingRequest { it.toCharacterUI() }

    fun fetchEpisode(id: Int) = fetchEpisodeByIdUseCase(id)

}