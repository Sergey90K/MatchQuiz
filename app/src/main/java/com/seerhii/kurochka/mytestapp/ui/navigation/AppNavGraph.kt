package com.seerhii.kurochka.mytestapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.seerhii.kurochka.mytestapp.ui.menuScreen.MenuDestination
import com.seerhii.kurochka.mytestapp.ui.menuScreen.MenuScreen
import com.seerhii.kurochka.mytestapp.ui.questionScreen.QuestionDestination
import com.seerhii.kurochka.mytestapp.ui.questionScreen.QuestionScreen
import com.seerhii.kurochka.mytestapp.ui.quizScreen.QuizDestination
import com.seerhii.kurochka.mytestapp.ui.quizScreen.QuizScreen
import com.seerhii.kurochka.mytestapp.ui.startScreen.StartDestination
import com.seerhii.kurochka.mytestapp.ui.startScreen.StartScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = StartDestination.route
    ) {
        composable(route = StartDestination.route) {
            StartScreen { navController.navigate(MenuDestination.route) }
        }
        composable(route = MenuDestination.route) {
            MenuScreen(
                navigateToQuiz = { navController.navigate(QuizDestination.route) },
                navigateToQuestion = { navController.navigate(QuestionDestination.route) },
                navigateToBack = { navController.navigateUp() }
            )
        }
        composable(route = QuizDestination.route) {
            QuizScreen(navigateToBack = { navController.navigateUp() })
        }
        composable(route = QuestionDestination.route) {
            QuestionScreen()
        }
    }
}