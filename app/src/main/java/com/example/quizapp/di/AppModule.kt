package com.example.quizapp.di

import com.example.quizapp.data.repository.QuizRepositoryImpl
import com.example.quizapp.data.source.QuizRegistrationSourceImp
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.domain.source.QuizRegistrationSource
import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AppModule {

    companion object{
        @Provides
        fun providesFirebaseAuth() = FirebaseAuth.getInstance()
    }

    @Binds
    abstract fun providesQuizSource(source: QuizRegistrationSourceImp): QuizRegistrationSource

    @Binds
    abstract fun providesRepository(repository: QuizRepositoryImpl): QuizRepository

}