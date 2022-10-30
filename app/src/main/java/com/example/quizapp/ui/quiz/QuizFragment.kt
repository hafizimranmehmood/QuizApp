package com.example.quizapp.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapp.databinding.QuizFragBinding
import com.example.quizapp.domain.model.Quiz

class QuizFragment : Fragment() {

    private val viewModel by activityViewModels<SharedQuizViewModel>()
    private lateinit var binding: QuizFragBinding
    private lateinit var adapter: QuizAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = QuizFragBinding.inflate(inflater)
        adapter = QuizAdapter()
        binding.quizList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.quizList.adapter = adapter

        viewModel.loadQuizzes()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observeQuizzes().observe(viewLifecycleOwner, ::updateQuizzes)
    }

    private fun updateQuizzes(quizzes: List<Quiz>) = adapter.submitList(quizzes)
}