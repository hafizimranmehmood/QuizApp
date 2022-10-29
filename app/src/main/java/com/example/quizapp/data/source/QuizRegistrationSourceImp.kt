package com.example.quizapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizapp.domain.model.Response
import com.example.quizapp.domain.model.Response.Error
import com.example.quizapp.domain.model.Response.Success
import com.example.quizapp.domain.source.QuizRegistrationSource
import com.example.quizapp.util.Constants
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class QuizRegistrationSourceImp @Inject constructor(
    private val auth: FirebaseAuth
) : QuizRegistrationSource {

    private val _registrationLiveData = MutableLiveData<Response>(Response.Loading)

    override fun validateSignUpInput(email: String, password: String, confirmPassword: String): Boolean {
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
            return false
        if(password != confirmPassword)
            return false

        if(password.length < Constants.MIN_PASSWORD_LENGTH)
            return false

//        val methods = auth.fetchSignInMethodsForEmail(email).addOnCompleteListener {
//
//        }
//        if(methods.result?.signInMethods?.size ?: 0 > 0)
//            return false
        return true
    }

    override fun validateSignInInput(email: String, password: String): Boolean {
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
            return false
        return true
    }

    override fun createUserWithEmailAndPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task -> handleTask(task) }
    }

    override fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task -> handleTask(task) }
    }

    override fun signOut() = auth.signOut()
    override fun isAlreadyLoggedIn() = auth.currentUser != null
    override fun observeRegistration(): LiveData<Response> = _registrationLiveData

    private fun handleTask(task: Task<AuthResult>){
        if (task.isSuccessful) {
            _registrationLiveData.value = Success
        } else {
            _registrationLiveData.value = Error(task.exception?.message ?: "")
        }
    }
}