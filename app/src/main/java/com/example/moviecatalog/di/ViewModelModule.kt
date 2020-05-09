package com.example.moviecatalog.di

import com.example.moviecatalog.modules.auth.viewmodel.LoginVM
import com.example.moviecatalog.modules.auth.viewmodel.RegisterVM
import com.example.moviecatalog.modules.main.viewmodel.MainVM
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainVM(get()) }
    factory { LoginVM(get()) }
    factory { RegisterVM(get()) }
}