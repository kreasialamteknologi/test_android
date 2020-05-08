package com.example.moviecatalog.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.moviecatalog.BuildConfig

fun debug(message: String){
    if (BuildConfig.DEBUG) Log.d("Result", message)
}

fun Activity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T: ViewDataBinding?> AppCompatActivity.setActBinding(layoutId: Int) : T {
    return DataBindingUtil.setContentView<T>(this, layoutId)
}

fun <T : ViewDataBinding?> Fragment.setFragBinding(layoutId: Int, container: ViewGroup?): T{
    return DataBindingUtil.inflate<T>(layoutInflater, layoutId, container, false)
}

fun <T : ViewDataBinding?> View.setLayoutBinding(layoutId: Int, container: ViewGroup?): T{
    return DataBindingUtil.inflate<T>(
        LayoutInflater.from(context),
        layoutId, container, false)
}

fun AppCompatActivity.context(): Context {
    return this
}

fun Any?.isNull() : Boolean = this == null


fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isPasswordValid(password: String): Boolean = password.length >= 6