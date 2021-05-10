package com.apptikar.yaskon.ui
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.scopes.ViewModelScoped


@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}