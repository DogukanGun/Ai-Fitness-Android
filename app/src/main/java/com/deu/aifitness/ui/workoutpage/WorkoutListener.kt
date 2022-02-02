package com.deu.aifitness.ui.workoutpage

import com.deu.aifitness.data.workout.Workout

interface WorkoutListener {

    fun workoutClicked(workout:Workout)
}