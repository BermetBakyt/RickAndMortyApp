package com.example.rickandmortynew.presentation.ui.fragments.episodes.detail

import com.example.domain.use_cases.FetchEpisodeByIdUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.EpisodeUI
import com.example.rickandmortynew.presentation.models.toEpisodeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val fetchEpisodeByIdUseCase: FetchEpisodeByIdUseCase
) : BaseViewModel() {

    private val _episodeDetailState = MutableUIStateFlow<EpisodeUI>()
    val episodeDetailState = _episodeDetailState.asStateFlow()

    fun fetchEpisodeDetail(id: Int) {
        fetchEpisodeByIdUseCase(id).collectRequest(_episodeDetailState) { it.toEpisodeUI() }
    }
}