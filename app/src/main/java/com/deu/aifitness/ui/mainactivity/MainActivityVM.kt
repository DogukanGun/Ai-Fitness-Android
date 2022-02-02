package com.deu.aifitness.ui.mainactivity

import android.content.Intent
import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivityVM:AIFitnessVM() {

    fun startTimer(){
        state.postValue(MainActivityVS.StartActivity)
    }
}