package com.example.quizapp.data.router

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.quizapp.domain.router.RegistrationRouter
import com.example.quizapp.ui.HomeActivity
import com.example.quizapp.ui.registration.LoginFragmentDirections
import com.example.quizapp.ui.registration.Screen
import com.example.quizapp.ui.registration.Screen.*
import com.example.quizapp.ui.registration.SignupFragmentDirections
import com.example.quizapp.ui.registration.WelcomeFragmentDirections
import javax.inject.Inject

class RegistrationRouterImpl @Inject constructor(
    private val activity: FragmentActivity,
    private val navController: NavController
): RegistrationRouter {

    override fun navigateTo(screen: Screen) {
        when(screen){
            is StartScreen -> navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment())
            is LoginScreen -> navController.navigate(SignupFragmentDirections.actionSignupFragmentToLoginFragment())
            is SignupScreen -> navController.navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
            is HomeScreen -> {
                activity.apply {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }
        }
    }
}