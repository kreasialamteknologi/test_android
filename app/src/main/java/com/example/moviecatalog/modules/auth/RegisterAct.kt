package com.example.moviecatalog.modules.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActRegisterBinding
import com.example.moviecatalog.modules.auth.viewmodel.RegisterVM
import com.example.moviecatalog.modules.main.MainAct
import com.example.moviecatalog.utils.setActBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterAct : AppCompatActivity() {

    private lateinit var binding: ActRegisterBinding
    private val viewModel: RegisterVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initViews()
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_register)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun initViews() {
        binding.btnRegister.setOnClickListener {
            viewModel.registerUser()
            startActivity(Intent(this, MainAct::class.java))
        }
    }
}
