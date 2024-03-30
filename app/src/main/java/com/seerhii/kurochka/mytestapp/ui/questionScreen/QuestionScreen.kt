package com.seerhii.kurochka.mytestapp.ui.questionScreen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.seerhii.kurochka.mytestapp.R
import com.seerhii.kurochka.mytestapp.ui.AppViewModelProvider
import com.seerhii.kurochka.mytestapp.ui.navigation.NavigationDestination
import com.seerhii.kurochka.mytestapp.ui.theme.MyTestAppTheme

object QuestionDestination : NavigationDestination {
    override val route = "question"
    override val titleRes = R.string.question_screen
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun QuestionScreen(questionViewModel: QuestionViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    val permissionState = rememberPermissionState(
        permission = Manifest.permission.RECORD_AUDIO
    )
    SideEffect {
        permissionState.launchPermissionRequest()
    }
    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = SpeechRecognizerContract(),
        onResult = {
            questionViewModel.changeTextValue(it.toString())
        }
    )

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
                    IconButton(
                        onClick = {
                            if (permissionState.status.isGranted) {
                                speechRecognizerLauncher.launch(Unit)
                            } else {
                                permissionState.launchPermissionRequest()
                            }
                        },
                        Modifier.size(dimensionResource(R.dimen.icon_button))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ai),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(dimensionResource(R.dimen.icon_button))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        AnimatedVisibility(
                            questionViewModel.state.text != null,
                            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
                            exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                        ) { ShowText(textString = questionViewModel.state.text!!) }
                        AnimatedVisibility(
                            questionViewModel.state.text == null,
                            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
                            exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                        ) { ShowText(textString = "Question Asked: ") }
                        AnimatedVisibility(
                            questionViewModel.answerState.text != null,
                            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
                            exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                        ) {  ShowText(textString = questionViewModel.answerState.text!!) }
                        AnimatedVisibility(
                            questionViewModel.answerState.text == null,
                            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
                            exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
                        ) {  ShowText(textString = "Answer: ")}

//                        if (questionViewModel.state.text != null) {
//                            ShowText(textString = questionViewModel.state.text!!)
//                        } else {
//                            ShowText(textString = "Question Asked: ")
//                        }
//                        if (questionViewModel.answerState.text != null) {
//                            ShowText(textString = questionViewModel.answerState.text!!)
//                        } else {
//                            ShowText(textString = "Answer: ")
//                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowText(textString: String) {
    Text(
        text = textString,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Black,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(dimensionResource(R.dimen.text_padding))
    )
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun GreetingPreview() {
    MyTestAppTheme {
        QuestionScreen()
    }
}