package com.example.quizapp.data.repository

import androidx.lifecycle.LiveData
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.model.Response
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.domain.source.QuizSource
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(private val source: QuizSource) : QuizRepository {

    override fun validateSignUpInput(
        email: String,
        password: String,
        confirmPassword: String
    ) = source.validateSignUpInput(email, password, confirmPassword)

    override fun validateSignInInput(email: String, password: String) = source.validateSignInInput(email, password)

    override fun createUserWithEmailAndPassword(email: String, password: String) {
        source.createUserWithEmailAndPassword(email, password)
    }

    override fun signInWithEmailAndPassword(email: String, password: String) {
        source.signInWithEmailAndPassword(email, password)
    }

    override fun isAlreadyLoggedIn() = source.isAlreadyLoggedIn()
    override fun observeRegistration(): LiveData<Response> = source.observeRegistration()
    override fun observeQuizzes(): LiveData<List<Quiz>> = source.observeQuizzes()
    override fun loadQuizzes() = source.loadQuizzes()
}