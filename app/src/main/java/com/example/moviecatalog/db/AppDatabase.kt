package com.example.moviecatalog.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviecatalog.db.dao.UserDao
import com.example.moviecatalog.db.entity.UserEntity

@Database(entities = [UserEntity::class], version = AppDatabase.DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao() : UserDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "note.db"
    }
}