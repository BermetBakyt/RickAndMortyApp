package com.example.rickandmortynew.di

import com.example.data.remote.RetrofitClient
import com.example.data.remote.services.CharacterApiService
import com.example.data.remote.services.EpisodeApiService
import com.example.data.remote.services.LocationApiService
import com.example.data.repository.CharacterRepositoryImpl
import com.example.data.repository.EpisodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.domain.repository.CharacterRepository
import com.example.domain.repository.EpisodeRepository
import com.example.domain.repository.LocationRepository
import org.koin.dsl.bind
import org.koin.dsl.module

    val repositoriesModule = module {

        single { CharacterRepositoryImpl(service = get()) } bind CharacterRepository::class

        single { LocationRepositoryImpl(service = get()) } bind LocationRepository::class

        single { EpisodeRepositoryImpl(service = get()) } bind EpisodeRepository::class

    }

val networkModule = module {
    single {
        RetrofitClient()
    }

    single {
        get<RetrofitClient>().provideCharacterApiService()
    }

    single {
        get<RetrofitClient>().provideEpisodeApiService()
    }

    single {
        get<RetrofitClient>().provideLocationApiService()
    }
}

