package com.example.quizapp.domain.model

sealed class Response {
    object Success: Response()
    data class Error(val message: String) : Response()
    object Loading: Response()
}
