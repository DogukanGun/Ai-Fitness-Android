package com.deu.aifitness.ui.workoutdetail

import com.deu.aifitness.application.AIFitnessState

sealed class WorkoutDetailVS:AIFitnessState {
    object StartWorkout:WorkoutDetailVS()
}