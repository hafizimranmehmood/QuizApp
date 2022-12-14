package com.example.quizapp.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizapp.databinding.WelcomeFragmentBinding
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.domain.router.QuizRouter
import com.example.quizapp.ui.quiz.Screen.*
import com.example.quizapp.ui.quiz.Screen.Register.Welcome
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFragmentBinding

    @Inject
    lateinit var repository: QuizRepository
    @Inject
    lateinit var registrationRouter: QuizRouter
    private val viewModel by activityViewModels<SharedQuizViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        if(viewModel.shouldNavigateToHome())
            registrationRouter.navigateTo(QuizScreen(Welcome))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener {
            registrationRouter.navigateTo(StartScreen)
        }
    }
}