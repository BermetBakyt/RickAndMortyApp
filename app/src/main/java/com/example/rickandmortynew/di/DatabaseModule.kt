package com.example.rickandmortynew.di

import android.content.Context
//import com.example.data.local.AppDatabase
//import com.example.data.local.RoomClient
//import com.example.data.local.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

//    @Singleton
//    val roomClient = RoomClient()
//
//    @Singleton
//    @Provides
//    fun provideAppDatabase(
//        @ApplicationContext context: Context
//    ): AppDatabase = roomClient.provideAppDatabase(context)
//
//    @Singleton
//    @Provides
//    fun provideCharacterDao(
//        appDatabase: AppDatabase
//    ): CharacterDao = roomClient.provideCharacterDao(appDatabase)
}