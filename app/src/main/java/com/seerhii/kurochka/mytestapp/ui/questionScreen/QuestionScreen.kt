package com.seerhii.kurochka.mytestapp.ui.questionScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination

object QuestionDestination : NavigationDestination {
    override val route = "question"
    override val titleRes = R.string.question_screen
}


@Composable
fun QuestionScreen() {
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
                    IconButton(onClick = { /*TODO*/ }, Modifier.size(200.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Description",
                            modifier = Modifier.size(190.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Question Asked: ",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(16.dp)
                        )

                        Text(
                            text = "Answer: ",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}