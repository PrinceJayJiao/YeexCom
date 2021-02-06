package com.example.yeexcom

import android.app.Application
import android.content.Context

class YeexComApplication:Application() {
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}