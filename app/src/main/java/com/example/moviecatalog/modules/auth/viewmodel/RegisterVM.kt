package com.example.moviecatalog.modules.auth.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalog.db.entity.UserEntity
import com.example.moviecatalog.repository.UserRepository
import com.example.moviecatalog.utils.isEmailValid
import com.example.moviecatalog.utils.isPasswordValid
import kotlinx.coroutines.launch

class RegisterVM(private val repository: UserRepository) : ViewModel() {

    val inputUserName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()
    val inputPassword = MutableLiveData<String>()

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

    fun registerUser() {
        viewModelScope.launch {
            repository.insertUser(
                UserEntity(
                    id = 0,
                    username = inputUserName.value ?: "",
                    email = inputEmail.value ?: "",
                    password = inputPassword.value ?: ""
                )
            )
        }
    }
}