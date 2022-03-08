package com.deu.aifitness.ui.homepage

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.workout.Workout

sealed class HomeVS:AIFitnessState {
    class SetWorkouts(val workouts: List<Workout>,val filter: List<String>): HomeVS()
    object NetworkError: HomeVS()
    class SetUsername(val username:String): HomeVS()
}