package com.example.moviecatalog.modules.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActSplashBinding
import com.example.moviecatalog.utils.setActBinding

class SplashAct : AppCompatActivity() {

    private lateinit var binding: ActSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_splash)
    }
}
