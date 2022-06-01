package com.example.rickandmortynew.di

import com.example.domain.repository.EpisodeRepository
import com.example.domain.repository.LocationRepository
import com.example.domain.use_cases.FetchCharacterByIdUseCase
import com.example.domain.use_cases.FetchEpisodeByIdUseCase
import com.example.domain.use_cases.FetchLocationByIdUseCase
import org.koin.core.scope.get
import org.koin.dsl.module

val domainModule = module {

    // Defines a factory (creates new instance every time)
    factory<FetchCharacterByIdUseCase>{
        FetchCharacterByIdUseCase(characterRepository = get())
    }

    factory<FetchEpisodeByIdUseCase> {
        FetchEpisodeByIdUseCase(episodeRepository = get())
    }

    factory<FetchLocationByIdUseCase> {
        FetchLocationByIdUseCase(locationRepository = get())
    }
}