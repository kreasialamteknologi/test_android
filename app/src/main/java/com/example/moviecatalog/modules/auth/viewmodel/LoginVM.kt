package com.example.moviecatalog.modules.auth.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalog.repository.UserRepository
import com.example.moviecatalog.utils.isEmailValid
import com.example.moviecatalog.utils.isPasswordValid
import kotlinx.coroutines.launch

class LoginVM(private val repository: UserRepository) : ViewModel() {
    val inputEmail = MutableLiveData<String>()
    val inputPassword = MutableLiveData<String>()

    val isValid = MutableLiveData<Boolean>()

    val validationEmail = MediatorLiveData<Boolean>().apply {
        addSource(inputEmail) {
            val valid = isEmailValid(it)
            value = valid
        }
    }

    val validationPassword = MediatorLiveData<Boolean>().apply {
        addSource(inputPassword) {
            val valid = isPasswordValid(it)
            value = valid
        }
    }

    fun loginUser(){
        val email: String = inputEmail.value ?: ""
        viewModelScope.launch {
            isValid.value = repository.getUserById(email).email == email
        }
    }
}