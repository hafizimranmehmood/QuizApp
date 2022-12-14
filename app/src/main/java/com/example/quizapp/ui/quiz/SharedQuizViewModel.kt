package com.example.quizapp.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.model.Response
import com.example.quizapp.domain.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedQuizViewModel @Inject constructor(
    private val repository: QuizRepository
) : ViewModel(){

    fun signUp(email: String, password: String, confirmPassword: String) {
        if(repository.validateSignUpInput(email, password, confirmPassword))
            repository.createUserWithEmailAndPassword(email, password)
    }

    fun singIn(email: String, password: String){
        if(repository.validateSignInInput(email, password))
            repository.signInWithEmailAndPassword(email, password)
    }

    fun loadQuizzes() = repository.loadQuizzes()
    fun observeRegistration(): LiveData<Response> = repository.observeRegistration()
    fun observeQuizzes(): LiveData<List<Quiz>> = repository.observeQuizzes()
    fun shouldNavigateToHome() = repository.isAlreadyLoggedIn()
}