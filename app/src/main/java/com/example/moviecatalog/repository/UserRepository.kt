package com.example.moviecatalog.repository

import com.example.moviecatalog.db.dao.UserDao
import com.example.moviecatalog.db.entity.UserEntity

class UserRepository (private val dao: UserDao){
    suspend fun insertUser(data: UserEntity) {
        dao.insertUser(data)
    }

    suspend fun getUserById(email: String): UserEntity = dao.getUserById(email)
}