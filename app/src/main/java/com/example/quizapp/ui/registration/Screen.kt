package com.example.quizapp.ui.registration

sealed class Screen {
    object StartScreen: Screen()
    object LoginScreen : Screen()
    object SignupScreen: Screen()
    object HomeScreen : Screen()
}
