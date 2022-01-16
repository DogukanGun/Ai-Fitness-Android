package com.deu.aifitness.ui.developerstartpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeveloperStartPageVM:ViewModel() {

    lateinit var state:MutableLiveData<DeveloperStartPageVS>

    fun hostButtonPressed(){
        state.value = DeveloperStartPageVS.environmentChangeToHost
    }

    fun localButtonPressed(){
        state.value = DeveloperStartPageVS.environmentChangeToHost
    }
}