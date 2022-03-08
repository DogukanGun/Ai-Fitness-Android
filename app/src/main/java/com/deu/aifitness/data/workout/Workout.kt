package com.deu.aifitness.data.workout

import android.media.Image
import android.widget.Button
import android.widget.ImageView

data class Workout (
    val id: Long,
    val workoutName: String,
    val workoutDescription: String,
    val workoutRating: Long,
    val workoutImage: String
)
