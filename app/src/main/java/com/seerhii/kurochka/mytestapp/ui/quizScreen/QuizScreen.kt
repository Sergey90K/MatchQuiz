package com.seerhii.kurochka.mytestapp.ui.quizScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.AppViewModelProvider
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination
import com.seerhii.kurochka.mytestapp.ui.theme.MyTestAppTheme
import com.seerhii.kurochka.mytestapp.ui.untils.GifImage
import com.seerhii.kurochka.mytestapp.ui.untils.playSound

object QuizDestination : NavigationDestination {
    override val route = "quiz"
    override val titleRes = R.string.quiz_screen
}

@Composable
fun QuizScreen(
    navigateToBack: () -> Unit,
    quizViewModel: QuizViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val picturesUiState by quizViewModel.picturesOfAnswer.collectAsStateWithLifecycle()
    val questionStringUiState by quizViewModel.questionString.collectAsStateWithLifecycle()
    val inputFieldUiState by quizViewModel.inputField.collectAsStateWithLifecycle()
    val finishedQuizUiState by quizViewModel.finishedQuiz.collectAsStateWithLifecycle()

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F, true)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GifImage(imageID = picturesUiState)
                    Text(
                        text = questionStringUiState,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(dimensionResource(R.dimen.text_padding))
                    )
                    ShowInputText(
                        inputFieldUiState = inputFieldUiState,
                        writeAnswer = quizViewModel::writeAnswer,
                    )
                    Divider(
                        Modifier.padding(
                            start = dimensionResource(R.dimen.divider_padding),
                            end = dimensionResource(R.dimen.divider_padding),
                            top = dimensionResource(R.dimen.padding_zero),
                            bottom = dimensionResource(R.dimen.divider_padding)
                        ), color = Color.White
                    )
                    Button(
                        onClick = {
                            if (finishedQuizUiState) {
                                navigateToBack()
                            } else {
                                quizViewModel.checkAnswer(context)
                            }
                        },
                        enabled = true
                    ) {
                        if (finishedQuizUiState) {
                            Text(stringResource(R.string.exit))
                        } else {
                            Text(
                                stringResource(R.string.submit)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowInputText(
    inputFieldUiState: String,
    writeAnswer: (String) -> Unit,
) {
    TextField(
        value = inputFieldUiState,
        onValueChange = { writeAnswer(it) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Gray,
            unfocusedContainerColor = Color.Gray,
            disabledContainerColor = Color.White,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, autoCorrect = true),
        // keyboardActions = KeyboardActions(onDone = {  }),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(R.dimen.divider_padding),
                end = dimensionResource(R.dimen.divider_padding)
            )
    )
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun GreetingPreview() {
    MyTestAppTheme {
        QuizScreen({})
    }
}