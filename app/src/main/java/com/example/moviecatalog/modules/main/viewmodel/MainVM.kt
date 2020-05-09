package com.example.moviecatalog.modules.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviecatalog.models.Movies
import com.example.moviecatalog.repository.MovieRepository
import com.example.moviecatalog.utils.debug
import kotlinx.coroutines.Dispatchers

class MainVM(private val repository: MovieRepository) : ViewModel() {

    val getTrendingMovie: LiveData<Movies> = liveData(Dispatchers.IO) {
        //val result = repository.getTrendingMovie()
        repository.getTrendingMovie().body()?.let { emit(it) }
        debug(repository.getTrendingMovie().body()?.total_pages.toString())
    }
}