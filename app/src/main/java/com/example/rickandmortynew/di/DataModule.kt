package com.example.rickandmortynew.di

import com.example.data.remote.RetrofitClient
import com.example.data.remote.services.CharacterApiService
import com.example.data.repository.CharacterRepositoryImpl
import com.example.data.repository.EpisodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.domain.repository.CharacterRepository
import com.example.domain.repository.EpisodeRepository
import com.example.domain.repository.LocationRepository
import org.koin.dsl.module

    val repositoriesModule = module {

        //Defines a singleton of Repository
        single<CharacterRepository> {
            CharacterRepositoryImpl(service = get())
        }

        single<EpisodeRepository> {
            EpisodeRepositoryImpl(service = get())
        }

        single<LocationRepository> {
            LocationRepositoryImpl(service = get())
        }
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
