package com.example.quizapp.data.source

import androidx.lifecycle.LiveData
import com.example.quizapp.domain.model.Response
import com.example.quizapp.domain.source.QuizRegistrationSource
import com.example.quizapp.util.Constants

class FakeQuizRegistrationSource : QuizRegistrationSource {

    private val existingUsers = listOf("username@abc.com")

    override fun validateSignUpInput(email: String, password: String, confirmPassword: String): Boolean {
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
            return false
        if(password != confirmPassword)
            return false
        if(password.length < Constants.MIN_PASSWORD_LENGTH)
            return false

        if(existingUsers.contains(email))
            return false
        return true
    }

    override fun validateSignInInput(email: String, password: String): Boolean {
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
            return false
        return true
    }

    override fun createUserWithEmailAndPassword(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun signInWithEmailAndPassword(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun isAlreadyLoggedIn(): Boolean {
        return false
    }

    override fun observeRegistration(): LiveData<Response> {
        TODO("Not yet implemented")
    }
}