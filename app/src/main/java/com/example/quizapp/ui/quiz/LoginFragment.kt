package com.example.quizapp.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizapp.databinding.LoginFragmentBinding
import com.example.quizapp.domain.model.Response
import com.example.quizapp.domain.model.Response.Loading
import com.example.quizapp.domain.model.Response.Success
import com.example.quizapp.domain.router.QuizRouter
import com.example.quizapp.ui.quiz.Screen.*
import com.example.quizapp.ui.quiz.Screen.Register.Login
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    @Inject
    lateinit var router: QuizRouter
    private val viewModel by activityViewModels<SharedQuizViewModel>()

    private lateinit var binding: LoginFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignup.setOnClickListener { router.navigateTo(SignupScreen) }
        binding.btnLogin.setOnClickListener { viewModel.singIn(binding.editEmailAddress.text.toString(), binding.editPassword.text.toString()) }
        viewModel.observeRegistration().observe(viewLifecycleOwner, ::handleResponse)
    }

    private fun handleResponse(response: Response){
        when(response){
            is Success -> router.navigateTo(QuizScreen(Login))
            is Response.Error -> Toast.makeText(requireContext(), response.message, Toast.LENGTH_LONG).show()
            is Loading -> {}
        }
    }
}