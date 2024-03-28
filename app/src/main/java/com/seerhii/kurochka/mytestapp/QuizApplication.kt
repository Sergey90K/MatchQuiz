package com.seerhii.kurochka.mytestapp

import android.app.Application
import com.seerhii.kurochka.mytestapp.data.AppContainer
import com.seerhii.kurochka.mytestapp.data.DefaultAppContainer

class QuizApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}