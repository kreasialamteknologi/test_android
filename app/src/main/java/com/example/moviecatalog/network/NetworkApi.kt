package com.example.moviecatalog.network

import com.example.moviecatalog.models.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies (@Query("api_key") apiKey: String) : Response<Movies>
}