package com.seerhii.kurochka.mytestapp.ui.startScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.seerhii.kurochka.mytestapp.data.WelcomePicturesList
import com.seerhii.kurochka.mytestapp.data.WelcomeSoundList
import com.seerhii.kurochka.mytestapp.ui.untils.playSound
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class StartViewModel() : ViewModel() {

    private val _picturesWelcome: MutableStateFlow<Int> =
        MutableStateFlow<Int>(
            WelcomePicturesList.welcomeList[Random.nextInt(
                0,
                WelcomePicturesList.welcomeList.size - 1
            )]
        )
    val picturesOfAnswer: StateFlow<Int> = _picturesWelcome.asStateFlow()

    fun playSoundIn(context: Context) {
        playSound(context, WelcomeSoundList.welcomeList[0])
    }
}