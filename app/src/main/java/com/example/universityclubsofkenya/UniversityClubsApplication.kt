package com.example.universityclubsofkenya

import android.app.Application
import com.example.universityclubsofkenya.data.AppContainer
import com.example.universityclubsofkenya.data.DefaultAppContainer

class UniversityClubsApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}