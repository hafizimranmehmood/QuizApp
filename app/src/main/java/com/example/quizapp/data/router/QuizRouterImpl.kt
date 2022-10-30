package com.example.quizapp.data.router

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.quizapp.domain.router.QuizRouter
import com.example.quizapp.ui.quiz.LoginFragmentDirections
import com.example.quizapp.ui.quiz.Screen
import com.example.quizapp.ui.quiz.Screen.*
import com.example.quizapp.ui.quiz.Screen.Register.*
import com.example.quizapp.ui.quiz.SignupFragmentDirections
import com.example.quizapp.ui.quiz.WelcomeFragmentDirections
import javax.inject.Inject

class QuizRouterImpl @Inject constructor(
    private val activity: FragmentActivity,
    private val navController: NavController
): QuizRouter {

    override fun navigateTo(screen: Screen) {
        when(screen){
            is StartScreen -> navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment())
            is LoginScreen -> navController.navigate(SignupFragmentDirections.actionSignupFragmentToLoginFragment())
            is SignupScreen -> navController.navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
            is QuizScreen -> navController.navigate(
                when(screen.register){
                    SignUp -> SignupFragmentDirections.actionSignupFragmentToQuizFragment()
                    Login -> LoginFragmentDirections.actionLoginFragmentToQuizFragment()
                    Welcome -> WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment()
                }
            )
//            {
//                activity.apply {
//                    startActivity(Intent(this, HomeActivity::class.java))
//                    finish()
//                }
//            }
        }
    }
}