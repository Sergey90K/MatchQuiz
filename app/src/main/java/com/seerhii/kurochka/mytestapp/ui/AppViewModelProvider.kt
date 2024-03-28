package com.seerhii.kurochka.mytestapp.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.seerhii.kurochka.mytestapp.QuizApplication
import com.seerhii.kurochka.mytestapp.ui.menuScreen.MenuViewModel
import com.seerhii.kurochka.mytestapp.ui.questionScreen.QuestionViewModel
import com.seerhii.kurochka.mytestapp.ui.quizScreen.QuizViewModel
import com.seerhii.kurochka.mytestapp.ui.startScreen.StartViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
         StartViewModel()
        }
        initializer {
            MenuViewModel()
        }
        initializer {
          QuestionViewModel()
        }
        initializer {
            QuizViewModel()
        }
    }
}

fun CreationExtras.quizApplication(): QuizApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as QuizApplication)