package com.example.quizapp.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.quizapp.data.router.QuizRouterImpl
import com.example.quizapp.domain.router.QuizRouter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import com.example.quizapp.R.id

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    companion object {
        @Provides
        fun providesFragment(activity: FragmentActivity): Fragment {
            return activity.supportFragmentManager.findFragmentById(id.fragmentContainerView) as NavHostFragment
        }

        @Provides
        fun providesNavController(fragment: Fragment) = fragment.findNavController()
    }

    @Binds
    abstract fun providesRouter(router: QuizRouterImpl): QuizRouter
}