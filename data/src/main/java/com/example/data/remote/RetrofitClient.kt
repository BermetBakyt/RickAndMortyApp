package com.example.data.remote

import com.example.data.BuildConfig
import com.example.data.remote.interceptors.LoggingInterceptor
import com.example.data.remote.services.CharacterApiService
import com.example.data.remote.services.EpisodeApiService
import com.example.data.remote.services.LocationApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient constructor() {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApiService = provideRetrofit
        .create(CharacterApiService::class.java)

    fun provideLocationApiService(): LocationApiService = provideRetrofit
        .create(LocationApiService::class.java)

    fun provideEpisodeApiService(): EpisodeApiService = provideRetrofit
        .create(EpisodeApiService::class.java)
}

