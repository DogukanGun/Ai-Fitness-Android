package com.deu.aifitness.ui.workoutpage

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.workout.Workout

sealed class WorkoutVS: AIFitnessState {
    class SetWorkouts(val workoutList:List<Workout>): WorkoutVS()
    object NetworkError: WorkoutVS()
}