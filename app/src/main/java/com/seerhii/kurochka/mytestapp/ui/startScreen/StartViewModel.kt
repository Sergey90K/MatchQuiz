package com.seerhii.kurochka.mytestapp.ui.startScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.seerhii.kurochka.mytestapp.data.WelcomeSoundList
import com.seerhii.kurochka.mytestapp.ui.untils.playSound

class StartViewModel() : ViewModel() {
    fun playSoundIn(context: Context) {
        playSound(context, WelcomeSoundList.welcomeList[0])
    }
}