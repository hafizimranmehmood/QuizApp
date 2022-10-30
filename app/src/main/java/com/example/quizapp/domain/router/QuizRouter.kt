package com.example.quizapp.domain.router

import com.example.quizapp.ui.quiz.Screen

interface QuizRouter {
    fun navigateTo(screen: Screen)
}