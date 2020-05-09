package com.example.moviecatalog.modules.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActSplashBinding
import com.example.moviecatalog.modules.auth.LoginAct
import com.example.moviecatalog.modules.auth.RegisterAct
import com.example.moviecatalog.modules.main.MainAct
import com.example.moviecatalog.utils.AuthSession
import com.example.moviecatalog.utils.setActBinding

class SplashAct : AppCompatActivity() {

    private lateinit var binding: ActSplashBinding

    override fun onStart() {
        super.onStart()

        if (AuthSession.getLoggedStatus(this)){
            startActivity(Intent(this, MainAct::class.java))
        } else return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initViews()
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_splash)
    }

    private fun initViews() {
        binding.btnToLogin.setOnClickListener {
            startActivity(Intent(this, LoginAct::class.java))
        }

        binding.btnToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterAct::class.java))
        }
    }
}
