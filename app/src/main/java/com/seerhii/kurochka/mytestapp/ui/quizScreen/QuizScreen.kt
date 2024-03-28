package com.seerhii.kurochka.mytestapp.ui.quizScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination
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
                        modifier = Modifier.padding(16.dp)
                    )
                    Divider(
                        Modifier.padding(
                            start = 20.dp,
                            end = 20.dp,
                            top = 10.dp,
                            bottom = 20.dp
                        ), color = Color.White
                    )
                    Button(
                        onClick = {},
                        enabled = true
                    ) {
                        Text("SUBMIT")
                    }
                }
            }
        }
    }
}