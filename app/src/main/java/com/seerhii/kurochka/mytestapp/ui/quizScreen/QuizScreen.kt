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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination
import com.seerhii.kurochka.mytestapp.ui.theme.MyTestAppTheme
import com.seerhii.kurochka.mytestapp.ui.untils.GifImage

object QuizDestination : NavigationDestination {
    override val route = "quiz"
    override val titleRes = R.string.quiz_screen
}

@Composable
fun QuizScreen() {
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
                    GifImage(imageID = R.drawable.excellent2)
                    Text(
                        text = "Question text",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(dimensionResource(R.dimen.text_padding))
                    )
                    ShowInputText()
                    Divider(
                        Modifier.padding(
                            start = dimensionResource(R.dimen.divider_padding),
                            end = dimensionResource(R.dimen.divider_padding),
                            top = dimensionResource(R.dimen.padding_zero),
                            bottom = dimensionResource(R.dimen.divider_padding)
                        ), color = Color.White
                    )
                    Button(
                        onClick = {},
                        enabled = true
                    ) {
                        Text(stringResource(R.string.submit))
                    }
                }
            }
        }
    }
}

@Composable
fun ShowInputText() {
    // val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Gray,
            unfocusedContainerColor = Color.Gray,
            disabledContainerColor = Color.White,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//        keyboardActions = KeyboardActions(
//            onDone = {
//                keyboardController?.hide()
//                // do something here
//            }
//        ),
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
        QuizScreen()
    }
}