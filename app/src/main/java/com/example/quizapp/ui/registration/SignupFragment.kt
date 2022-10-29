package com.example.quizapp.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizapp.databinding.SignupFragmentBinding
import com.example.quizapp.domain.model.Response
import com.example.quizapp.domain.model.Response.Loading
import com.example.quizapp.domain.model.Response.Success
import com.example.quizapp.domain.router.RegistrationRouter
import com.example.quizapp.ui.registration.Screen.HomeScreen
import com.example.quizapp.ui.registration.Screen.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignupFragment : Fragment() {

    @Inject
    lateinit var router: RegistrationRouter
    private lateinit var binding: SignupFragmentBinding
    private val viewModel by activityViewModels<SharedQuizViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignupFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener { router.navigateTo(LoginScreen) }
        binding.btnSignup.setOnClickListener {
            viewModel.signUp(
                binding.editEmailAddress.text.toString(),
                binding.editPassword.text.toString(),
                binding.editConfirmPassword.text.toString()
            )
        }
        viewModel.observeRegistration().observe(viewLifecycleOwner, ::handleResponse)
    }

    private fun handleResponse(response: Response){
        when(response){
            is Success -> router.navigateTo(HomeScreen)
            is Response.Error -> Toast.makeText(requireContext(), response.message, Toast.LENGTH_LONG).show()
            is Loading -> {}
        }
    }
}