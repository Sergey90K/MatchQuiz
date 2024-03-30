package com.seerhii.kurochka.mytestapp.ui.startScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.AppViewModelProvider
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination
import com.seerhii.kurochka.mytestapp.ui.theme.MyTestAppTheme
import com.seerhii.kurochka.mytestapp.ui.untils.GifImage

object StartDestination : NavigationDestination {
    override val route = "start"
    override val titleRes = R.string.startscreen
}

@Composable
fun StartScreen(
    startViewModel: StartViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateToMenuScreen: () -> Unit
) {

    val welcomePicturesUiState by startViewModel.picturesOfAnswer.collectAsStateWithLifecycle()

    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue
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
                    GifImage(imageID = welcomePicturesUiState)
                    Button(
                        onClick = {
                            navigateToMenuScreen()
                            startViewModel.playSoundIn(context)
                        },
                        enabled = true
                    ) {
                        Text(stringResource(R.string.start))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun GreetingPreview() {
    MyTestAppTheme {
        //StartScreen({ })
    }
}