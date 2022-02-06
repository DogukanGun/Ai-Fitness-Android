package com.deu.aifitness.ui.workoutdetail

import com.deu.aifitness.application.AIFitnessVM

class WorkoutDetailVM: AIFitnessVM() {

    fun buttonPressed(){
        state.postValue(WorkoutDetailVS.StartWorkout)
    }
}