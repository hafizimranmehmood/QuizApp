package com.example.quizapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.model.Response

interface QuizRepository {
    fun validateSignUpInput(email: String, password: String, confirmPassword: String): Boolean
    fun validateSignInInput(email: String, password: String): Boolean
    fun createUserWithEmailAndPassword(email: String, password: String)
    fun signInWithEmailAndPassword(email: String, password: String)
    fun isAlreadyLoggedIn(): Boolean
    fun observeRegistration(): LiveData<Response>
    fun observeQuizzes(): LiveData<List<Quiz>>
    fun loadQuizzes()
}