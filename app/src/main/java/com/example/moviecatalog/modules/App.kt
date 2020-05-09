package com.example.moviecatalog.modules

import android.app.Application
import com.example.moviecatalog.di.databaseModule
import com.example.moviecatalog.di.networkModule
import com.example.moviecatalog.di.repositoryModule
import com.example.moviecatalog.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(listOf(
                networkModule,
                repositoryModule,
                viewModelModule,
                databaseModule
            ))
        }
    }
}