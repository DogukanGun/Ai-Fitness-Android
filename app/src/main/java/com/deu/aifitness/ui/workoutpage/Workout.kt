package com.deu.aifitness.ui.workoutpage

import android.media.Image
import android.widget.Button
import android.widget.ImageView

data class Workout(
    val workoutImage: String,
    val workoutName: String,
    val starImage: Int,
    val description: String,
    val btn: String
)