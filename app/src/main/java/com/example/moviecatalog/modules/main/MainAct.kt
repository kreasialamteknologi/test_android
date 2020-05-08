package com.example.moviecatalog.modules.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActMainBinding
import com.example.moviecatalog.utils.setActBinding

class MainAct : AppCompatActivity() {

    private lateinit var binding: ActMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_main)
    }
}
