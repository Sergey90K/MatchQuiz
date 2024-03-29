package com.seerhii.kurochka.mytestapp.ui.menuScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.seerhii.kurochka.mytestapp.data.OkaySoundList
import com.seerhii.kurochka.mytestapp.ui.untils.playSound
import kotlin.random.Random

class MenuViewModel() : ViewModel() {
    fun playSoundIn(context: Context) {
        playSound(
            context,
            OkaySoundList.okayList[Random.nextInt(0, OkaySoundList.okayList.size - 1)]
        )
    }
}