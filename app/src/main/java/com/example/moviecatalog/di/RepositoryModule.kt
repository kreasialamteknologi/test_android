package com.example.moviecatalog.di

import com.example.moviecatalog.repository.MovieRepository
import com.example.moviecatalog.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { MovieRepository(get()) }
    factory { UserRepository(get()) }
}