package com.example.rickandmortynew

import android.app.Application
import com.example.rickandmortynew.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RickAndMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@RickAndMortyApp)
            modules(listOf(presentationModule, domainModule, repositoriesModule, networkModule))
        }
    }
}