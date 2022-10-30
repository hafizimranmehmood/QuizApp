package com.example.quizapp.ui.quiz

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.QuizeItemBinding
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.ui.quiz.QuizAdapter.QuizViewHolder
import com.example.quizapp.util.ColorResPicker
import com.example.quizapp.util.IconPicker

class QuizAdapter : ListAdapter<Quiz, QuizViewHolder>(DIFF_UTIL_CALLBACK){

    companion object {
        private val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Quiz>(){
            override fun areItemsTheSame(oldItem: Quiz, newItem: Quiz) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Quiz, newItem: Quiz) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = QuizViewHolder.from(parent)
    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) = holder.bind(getItem(position))

    class QuizViewHolder private constructor(
        private val binding: QuizeItemBinding,
        private val context: Context
    ): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup) = QuizViewHolder(QuizeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)
        }

        fun bind(quiz: Quiz){
            binding.quizTitle.text = quiz.title
            binding.quizIcon.setImageResource(IconPicker.getIcon())
            val color = context.resources.getColor(ColorResPicker.getColorResId())
            binding.root.setCardBackgroundColor(color)
        }
    }
}