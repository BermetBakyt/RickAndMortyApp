package com.example.rickandmortynew.presentation.ui.fragments.character

import com.example.data.repository.CharacterRepositoryImpl
import com.example.domain.use_cases.FetchEpisodeByIdUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.EpisodeUI
import com.example.rickandmortynew.presentation.models.toCharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterPagingViewModel @Inject constructor(
    private val characterRepository: CharacterRepositoryImpl,
    private val fetchEpisodeByIdUseCase: FetchEpisodeByIdUseCase
) : BaseViewModel() {

    private val _episodeDetailState = MutableUIStateFlow<EpisodeUI>()
    val episodeDetailState = _episodeDetailState.asStateFlow()

    fun fetchCharactersPaging() =
        characterRepository.fetchCharactersPaging().collectPagingRequest { it.toCharacterUI() }
}