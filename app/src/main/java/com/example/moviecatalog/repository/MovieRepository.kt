package com.example.moviecatalog.repository

import com.example.moviecatalog.BuildConfig
import com.example.moviecatalog.models.Movies
import com.example.moviecatalog.network.NetworkApi
import retrofit2.Response

class MovieRepository (private val service: NetworkApi){
    suspend fun getTrendingMovie(): Response<Movies> = service.getTrendingMovies(BuildConfig.API_KEY)
}