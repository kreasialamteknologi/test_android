package com.example.moviecatalog.db.dao

import androidx.room.*
import com.example.moviecatalog.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(data: UserEntity)

    @Query("SELECT * from user_table where email = :email LIMIT 1")
    suspend fun getUserById(email: String): UserEntity

    @Update
    suspend fun updateNote(data: UserEntity)

    @Delete
    suspend fun deleteNote(data: UserEntity)

}