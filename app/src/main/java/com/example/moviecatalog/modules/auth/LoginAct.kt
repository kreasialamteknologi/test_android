package com.example.moviecatalog.modules.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActLoginBinding
import com.example.moviecatalog.utils.setActBinding

class LoginAct : AppCompatActivity() {

    private lateinit var binding: ActLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_login)
    }
}
