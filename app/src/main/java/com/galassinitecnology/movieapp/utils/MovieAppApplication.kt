package com.galassinitecnology.movieapp.utils

import android.app.Application
import com.galassinitecnology.movieapp.di.listModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MovieAppApplication)
            modules(listModules)
        }
    }

}