package com.example.rickandmortynew.presentation.ui.fragments.characterpaging

import com.example.data.repository.CharacterRepositoryImpl
import com.example.data.repository.EpisodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toCharacterUI
import com.example.rickandmortynew.presentation.models.toEpisodeUI
import com.example.rickandmortynew.presentation.models.toLocationUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterPagingViewModel @Inject constructor(
    private val characterRepository: CharacterRepositoryImpl,
    private val episodeRepository: EpisodeRepositoryImpl,
    private val locationRepository: LocationRepositoryImpl,
) : BaseViewModel() {

    fun fetchCharactersPaging() =
        characterRepository.fetchCharactersPaging().collectPagingRequest { it.toCharacterUI() }

    fun fetchEpisodePaging(id: Int) =
        episodeRepository.fetchEpisodesPaging().collectPagingRequest { it.toEpisodeUI() }

    fun fetchLocationPaging() =
        locationRepository.fetchLocationsPaging().collectPagingRequest { it.toLocationUI() }
}