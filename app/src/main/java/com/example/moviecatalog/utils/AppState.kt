package com.example.moviecatalog.utils

sealed class AppState {
    data class Success(var message: String?) : AppState()
    data class Error(var error: String?) : AppState()
    data class Loading(var loading: Boolean = false) : AppState()
}