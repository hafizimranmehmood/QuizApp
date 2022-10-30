package com.example.quizapp.ui.quiz

sealed class Screen {
    enum class Register {
        SignUp,
        Login,
        Welcome
    }
    object StartScreen: Screen()
    object LoginScreen : Screen()
    object SignupScreen: Screen()
    data class QuizScreen(val register: Register) : Screen()
}
