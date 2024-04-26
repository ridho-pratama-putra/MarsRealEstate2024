package com.example.marsrealestate2024

import android.app.Application
import timber.log.Timber

class MarsRealEstateApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}