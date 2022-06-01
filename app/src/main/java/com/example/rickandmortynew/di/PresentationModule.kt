package com.example.rickandmortynew.di

import com.example.rickandmortynew.presentation.ui.fragments.character.CharacterPagingViewModel
import com.example.rickandmortynew.presentation.ui.fragments.detail.CharacterDetailViewModel
import com.example.rickandmortynew.presentation.ui.fragments.episodes.EpisodesViewModel
import com.example.rickandmortynew.presentation.ui.fragments.episodes.detail.EpisodeDetailViewModel
import com.example.rickandmortynew.presentation.ui.fragments.location.LocationsViewModel
import com.example.rickandmortynew.presentation.ui.fragments.location.detail.LocationDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<CharacterDetailViewModel> {
        CharacterDetailViewModel(
            fetchCharacterByIdUseCase = get()
        )
    }

    viewModel<CharacterPagingViewModel> {
        CharacterPagingViewModel(
            characterRepository = get(),
            fetchEpisodeByIdUseCase = get()
        )
    }

    viewModel<LocationsViewModel> {
        LocationsViewModel(
             locationRepository = get()
        )
    }

    viewModel<LocationDetailViewModel> {
        LocationDetailViewModel(
            fetchLocationByIdUseCase = get()
        )
    }

    viewModel<EpisodesViewModel> {
        EpisodesViewModel(
            episodeRepository = get()
        )
    }

    viewModel<EpisodeDetailViewModel> {
        EpisodeDetailViewModel(
            fetchEpisodeByIdUseCase = get()
        )
    }

}