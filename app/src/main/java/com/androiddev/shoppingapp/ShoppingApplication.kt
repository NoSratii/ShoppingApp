package com.androiddev.shoppingapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShoppingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}