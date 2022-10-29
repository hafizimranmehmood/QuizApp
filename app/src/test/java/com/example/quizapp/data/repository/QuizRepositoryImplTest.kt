package com.example.quizapp.data.repository

import com.example.quizapp.data.source.FakeQuizRegistrationSource
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.util.Constants
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class QuizRepositoryImplTest {

    private lateinit var repository: QuizRepository
    private lateinit var password: String

    @Before
    fun setUp(){
        password = buildString {
            for(i in 1 until Constants.MIN_PASSWORD_LENGTH)
                append(i)
        }
        repository = QuizRepositoryImpl(FakeQuizRegistrationSource())
    }


    @Test
    fun validateSignUpInput_emptyEmail_returnFalse(){
        val result = repository.validateSignUpInput(
            "",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignUpInput_emptyPassword_returnFalse(){
        val result = repository.validateSignUpInput(
            "username",
            "",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignUpInput_incorrectConfirmPassword_returnFalse(){
        val result = repository.validateSignUpInput(
            "username",
            "1234",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignUpInput_emailAlreadyExists_returnFalse(){
        val result = repository.validateSignUpInput(
            "username@abc.com",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignUpInput_shortPasswordLength_returnFalse(){
        val result = repository.validateSignUpInput(
            "username",
            password,
            password
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignUpInput_validEmailPasswords_returnTrue(){
        password = password.plus(1)
        val result = repository.validateSignUpInput(
            "username",
            password,
            password
        )

        assertThat(result).isTrue()
    }

    @Test
    fun validateSignInInput_emptyEmail_returnFalse(){
        val result = repository.validateSignInInput(
            "",
            password
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignInInput_emptyPassword_returnFalse(){
        val result = repository.validateSignInInput(
            "username",
            ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun validateSignInInput_validEmailPasswords_returnTrue(){
        password = password.plus(1)
        val result = repository.validateSignInInput(
            "username",
            password
        )

        assertThat(result).isTrue()
    }
}