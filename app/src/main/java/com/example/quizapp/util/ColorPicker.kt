package com.example.quizapp.util

import com.example.quizapp.R

object ColorResPicker {
    //alt+ctrl+L to format
    private val colors = arrayOf(
        R.color.color1,
        R.color.color2,
        R.color.color3,
        R.color.color4,
        R.color.color5,
        R.color.color6,
        R.color.color7,
        R.color.color8,
        R.color.color9,
        R.color.color10,
        R.color.color11,
        R.color.color12,
        R.color.color13
    )

    private var currentColorIndex = 0

    fun getColorResId(): Int{
        currentColorIndex = ( currentColorIndex + 1 ) % colors.size
        return colors[currentColorIndex]
    }
}