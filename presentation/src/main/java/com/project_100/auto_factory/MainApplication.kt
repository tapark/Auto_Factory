package com.project_100.auto_factory

import android.app.Application
import com.teddy_park.data.preference.PrefManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        PrefManager.init(applicationContext)
    }

}