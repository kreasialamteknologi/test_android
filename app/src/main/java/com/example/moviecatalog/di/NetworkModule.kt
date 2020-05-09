package com.example.moviecatalog.di

import com.example.moviecatalog.BuildConfig
import com.example.moviecatalog.network.NetworkApi
import com.example.moviecatalog.network.NetworkService.createHttpClient
import com.example.moviecatalog.network.NetworkService.createWebService
import org.koin.dsl.module

val networkModule = module {
    single {
        createWebService<NetworkApi>(
            createHttpClient(),
            BuildConfig.BASE_URL
        )
    }
}