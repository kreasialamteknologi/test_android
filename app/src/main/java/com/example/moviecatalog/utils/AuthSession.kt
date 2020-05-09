package com.example.moviecatalog.utils

import android.content.Context
import androidx.core.content.edit


object AuthSession {

    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val editor = context.getSharedPreferences("", Context.MODE_PRIVATE)
        editor?.edit {
            putBoolean(Constants.LOGGED_IN_PREF, loggedIn)
        }
    }

    fun getLoggedStatus(context: Context): Boolean {
        return context.getSharedPreferences("", Context.MODE_PRIVATE)
            .getBoolean(Constants.LOGGED_IN_PREF, false)
    }
}