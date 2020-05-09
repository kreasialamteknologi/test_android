package com.example.moviecatalog.modules.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActLoginBinding
import com.example.moviecatalog.modules.auth.viewmodel.LoginVM
import com.example.moviecatalog.modules.main.MainAct
import com.example.moviecatalog.utils.context
import com.example.moviecatalog.utils.setActBinding
import com.example.moviecatalog.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginAct : AppCompatActivity() {

    private lateinit var binding: ActLoginBinding
    private val viewModel: LoginVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        retrieveLiveData()
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_login)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun retrieveLiveData() {
        viewModel.isValid.observe(this, Observer {
            if (it == true) startActivity(Intent(context(), MainAct::class.java))
            else toast("Sorry, no user")
        })
    }
}
