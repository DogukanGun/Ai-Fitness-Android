package com.deu.aifitness.ui.developerstartpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deu.aifitness.application.AIFitnessVM

class DeveloperStartPageVM:AIFitnessVM() {

    fun hostButtonPressed(){
        state.value = DeveloperStartPageVS.EnvironmentChangeToHost
    }

    fun localButtonPressed(){
        state.value = DeveloperStartPageVS.EnvironmentChangeToLocal
    }
}