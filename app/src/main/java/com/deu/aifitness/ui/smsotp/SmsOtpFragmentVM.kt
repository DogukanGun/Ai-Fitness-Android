package com.deu.aifitness.ui.smsotp

import com.deu.aifitness.application.AIFitnessVM

class SmsOtpFragmentVM:AIFitnessVM() {

    fun postOtpCode(list: List<Int>){
        state.postValue(SmsOtpFragmentVS.SuccessResult)
    }
}