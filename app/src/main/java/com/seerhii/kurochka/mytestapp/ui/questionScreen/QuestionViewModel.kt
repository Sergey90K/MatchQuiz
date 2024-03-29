package com.seerhii.kurochka.mytestapp.ui.questionScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuestionViewModel() : ViewModel(){
    var state by mutableStateOf(MainScreenState())
        private set
    var answerState by mutableStateOf(MainScreenState())
        private set

    fun changeTextValue(text:String){
        viewModelScope.launch {
            state = state.copy(
                text = text
            )
        }
    }
}