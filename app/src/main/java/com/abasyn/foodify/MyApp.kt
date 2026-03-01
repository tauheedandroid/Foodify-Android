package com.abasyn.foodify

import android.app.Application
import com.abasyn.foodify.di.appModule
import com.google.android.material.shape.ShapeAppearanceModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }

    }
}