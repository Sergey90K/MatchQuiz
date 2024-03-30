package com.seerhii.kurochka.mytestapp.ui.quizScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.seerhii.kurochka.mytestapp.data.GoodSoundList
import com.seerhii.kurochka.mytestapp.data.QuestionList
import com.seerhii.kurochka.mytestapp.data.QuestionPicturesList
import com.seerhii.kurochka.mytestapp.data.VeryGoodPicturesList
import com.seerhii.kurochka.mytestapp.data.WrongAnswerPicturesList
import com.seerhii.kurochka.mytestapp.data.WrongSoundList
import com.seerhii.kurochka.mytestapp.ui.untils.playSound
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.NumberFormatException
import kotlin.random.Random

class QuizViewModel() : ViewModel() {
    private var numberOfQuestion = 0
    private val _picturesOfAnswer: MutableStateFlow<Int> =
        MutableStateFlow<Int>(
            QuestionPicturesList.questionPictures[getRandomForList(QuestionPicturesList.questionPictures)]
        )
    val picturesOfAnswer: StateFlow<Int> = _picturesOfAnswer.asStateFlow()

    private val _questionString: MutableStateFlow<String> =
        MutableStateFlow<String>(QuestionList.question[numberOfQuestion].questionText)
    val questionString: StateFlow<String> = _questionString.asStateFlow()

    private val _inputField: MutableStateFlow<String> = MutableStateFlow<String>("")
    val inputField: StateFlow<String> = _inputField.asStateFlow()

    private val _finishedQuiz: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val finishedQuiz: StateFlow<Boolean> = _finishedQuiz.asStateFlow()

    fun writeAnswer(inputDta: String) {
        _inputField.value = inputDta
    }

    fun playSoundInner(context: Context, correctAnswer: Boolean) {
        if (correctAnswer) {
            playSound(
                context = context,
                GoodSoundList.goodList[getRandomForList(GoodSoundList.goodList)]
            )
        } else {
            playSound(
                context = context,
                WrongSoundList.wrongList[getRandomForList(WrongSoundList.wrongList)]
            )
        }
    }

    fun checkAnswer(context: Context) {
        try {
            if (QuestionList.question.size > numberOfQuestion) {
                if (QuestionList.question[numberOfQuestion].answer == inputField.value.toInt()) {
                    _picturesOfAnswer.value =
                        VeryGoodPicturesList.veryPictures[getRandomForList(VeryGoodPicturesList.veryPictures)]
                    numberOfQuestion++
                    if (QuestionList.question.size > numberOfQuestion) {
                        _questionString.value = QuestionList.question[numberOfQuestion].questionText
                        _inputField.value = ""
                    } else {
                        _questionString.value = "You have answered everything correctly."
                        _finishedQuiz.value = true
                        _inputField.value = "The questions are over."
                    }
                    playSoundInner(context, true)
                } else {
                    _picturesOfAnswer.value =
                        WrongAnswerPicturesList.wrongPictures[getRandomForList(
                            WrongAnswerPicturesList.wrongPictures
                        )]
                    _inputField.value = ""
                    playSoundInner(context, false)
                }
            } else {
                _finishedQuiz.value = true
                playSoundInner(context, true)
            }
        } catch (e: NumberFormatException) {
            _picturesOfAnswer.value =
                WrongAnswerPicturesList.wrongPictures[getRandomForList(WrongAnswerPicturesList.wrongPictures)]
            playSoundInner(context, false)
            _inputField.value = ""
        }
    }

    private fun getRandomForList(list: List<Int>): Int {
        return Random.nextInt(0, list.size - 1)
    }
}

