package com.seerhii.kurochka.mytestapp.ui.menuScreen

import android.content.Context
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.AppViewModelProvider
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination
import com.seerhii.kurochka.mytestapp.ui.theme.MyTestAppTheme

object MenuDestination : NavigationDestination {
    override val route = "menu"
    override val titleRes = R.string.menuscreen
}

@Composable
fun MenuScreen(
    navigateToQuiz: () -> Unit,
    navigateToQuestion: () -> Unit,
    navigateToBack: () -> Unit,
    menuViewModel: MenuViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                IconButton(
                    onClick = {
                        navigateToBack()
                        menuViewModel.playSoundIn(context)
                    },
                    Modifier
                        .size(dimensionResource(R.dimen.icon_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                ) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = stringResource(R.string.go_back),
                        Modifier.size(dimensionResource(R.dimen.icon_size))
                    )
                }
                IconButton(
                    onClick = { menuViewModel.playSoundIn(context) },
                    Modifier
                        .size(dimensionResource(R.dimen.icon_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                ) {
                    Icon(
                        Icons.Outlined.AccountCircle,
                        contentDescription = stringResource(R.string.account_settings),
                        Modifier.size(dimensionResource(R.dimen.icon_size))
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.maths_tutor),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            ShowAllCard(
                navigateToQuestion = navigateToQuestion,
                navigateToQuiz = navigateToQuiz,
                playSound = menuViewModel::playSoundIn,
                context = context
            )
        }
    }
}

@Composable
fun ShowAllCard(
    navigateToQuiz: () -> Unit,
    navigateToQuestion: () -> Unit,
    playSound: (Context) -> Unit,
    context: Context
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_big)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ShowCard(
                    navigateToQuiz,
                    R.drawable.mathsnew,
                    stringResource(R.string.match_quiz),
                    playSound = playSound,
                    context = context
                )
                ShowCard(
                    {},
                    R.drawable.story,
                    stringResource(R.string.learn),
                    playSound = playSound,
                    context = context
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_big)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ShowCard(
                    { },
                    R.drawable.artdraw,
                    stringResource(R.string.multiplayer),
                    playSound = playSound,
                    context = context
                )
                ShowCard(
                    {},
                    R.drawable.lessons,
                    stringResource(R.string.draw),
                    playSound = playSound,
                    context = context
                )

            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_big)),
                horizontalArrangement = Arrangement.Center
            ) {
                ShowCard(
                    navigateToQuestion,
                    R.drawable.ai,
                    stringResource(R.string.ai_chatbot),
                    playSound = playSound,
                    context = context
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowCard(
    navigateTo: () -> Unit,
    idImage: Int,
    labelString: String,
    playSound: (Context) -> Unit,
    context: Context
) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.errorContainer),
        modifier = Modifier
            .size(
                width = dimensionResource(R.dimen.card_width),
                height = dimensionResource(R.dimen.card_height)
            )
            .padding(dimensionResource(R.dimen.padding_medium)),
        onClick = {
            playSound(context)
            navigateTo()
        }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = idImage),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
                )
                Text(
                    labelString,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge, maxLines = 2,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun GreetingPreview() {
    MyTestAppTheme {
        MenuScreen(navigateToQuiz = { /*TODO*/ }, navigateToQuestion = {}, navigateToBack = {})
    }
}