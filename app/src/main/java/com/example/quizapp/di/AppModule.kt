package com.example.quizapp.di

import com.example.quizapp.data.repository.QuizRepositoryImpl
import com.example.quizapp.data.source.QuizSourceImp
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.domain.source.QuizSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AppModule {

    companion object{
        @Provides
        fun providesFirebaseAuth() = FirebaseAuth.getInstance()

        @Provides
        fun providesFirebaseFirestore() = Firebase.firestore
    }

    @Binds
    abstract fun providesQuizSource(source: QuizSourceImp): QuizSource

    @Binds
    abstract fun providesRepository(repository: QuizRepositoryImpl): QuizRepository

}