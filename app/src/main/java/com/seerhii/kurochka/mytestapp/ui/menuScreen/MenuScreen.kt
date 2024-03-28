package com.seerhii.kurochka.mytestapp.ui.menuScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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

object MenuDestination : NavigationDestination {
    override val route = "menu"
    override val titleRes = R.string.menuscreen
}

@Composable
fun MenuScreen(navigateToQuiz: () -> Unit, navigateToQuestion: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Red
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                IconButton(
                    onClick = { /* doSomething() */ },
                    Modifier
                        .size(50.dp)
                        .padding(2.dp)
                ) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = "Localized description",
                        Modifier.size(50.dp)
                    )
                }
                IconButton(
                    onClick = { /* doSomething() */ },
                    Modifier
                        .size(50.dp)
                        .padding(2.dp)
                ) {
                    Icon(
                        Icons.Outlined.AccountCircle,
                        contentDescription = "Localized description",
                        Modifier.size(50.dp)
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Maths Tutor",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            ShowAllCard(navigateToQuestion = navigateToQuestion, navigateToQuiz = navigateToQuiz)
        }
    }
}

@Composable
fun ShowAllCard(navigateToQuiz: () -> Unit, navigateToQuestion: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
    ) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ShowCard(navigateToQuiz)
                ShowCard({})
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ShowCard({})
                ShowCard({})

            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.Center
            ) {
                ShowCard(navigateToQuestion)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowCard(navigateTo: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier
            .size(width = 180.dp, height = 200.dp)
            .padding(5.dp),
        onClick = { navigateTo() }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
                Text("Card content description", textAlign = TextAlign.Center)
            }

        }
    }
}