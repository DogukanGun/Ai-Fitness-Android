package com.deu.aifitness.application

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageVS

open class AIFitnessVM:ViewModel(){
    val state = MutableLiveData<AIFitnessState>()
    val session = AIFitnessSession.getInstance()
}