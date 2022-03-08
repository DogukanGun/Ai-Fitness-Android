package com.deu.aifitness.ui.workoutdetail

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.workout.Workout

sealed class WorkoutDetailVS:AIFitnessState {
    object StartWorkout: WorkoutDetailVS()
    object NegativeResponse: WorkoutDetailVS()
    class SetWorkout(val workout:Workout): WorkoutDetailVS()
}