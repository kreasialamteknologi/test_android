package com.example.moviecatalog.models

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<Movie>,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("total_results") val total_results : Int
)

data class Movie(
    @SerializedName("id") val id : Int,
    @SerializedName("video") val video : Boolean,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("vote_average") val vote_average : Float,
    @SerializedName("title") val title : String,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("genre_ids") val genre_ids : List<Int>,
    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("media_type") val media_type : String
)