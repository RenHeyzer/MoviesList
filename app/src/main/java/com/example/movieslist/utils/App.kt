package com.example.movieslist.utils

import android.app.Application
import com.example.movieslist.servicelocator.networkModule
import com.example.movieslist.servicelocator.repositoriesModule
import com.example.movieslist.servicelocator.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(viewModelsModule, repositoriesModule, networkModule)
        }
    }
}