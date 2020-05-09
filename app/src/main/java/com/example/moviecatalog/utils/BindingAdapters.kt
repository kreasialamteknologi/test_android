package com.example.moviecatalog.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.example.moviecatalog.R
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:imageUrl")
fun setProfileImage(view: AppCompatImageView, imageUrl: String?) {
    view.load(imageUrl){
        placeholder(R.drawable.ic_image_24dp)
    }
}

@BindingAdapter("app:errorText")
fun setErrorMessage(view: TextInputLayout, message: String) {
    val text = view.editText?.text.toString().trim()
    if (text.isNotEmpty() && text != "") {
        view.error = message
    }
}