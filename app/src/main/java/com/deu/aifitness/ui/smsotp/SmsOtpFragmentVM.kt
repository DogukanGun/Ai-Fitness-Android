package com.deu.aifitness.ui.smsotp

import com.deu.aifitness.application.AIFitnessVM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class SmsOtpFragmentVM:AIFitnessVM() {

    var phoneNumber = ""
    var pinNumber = ""
    fun postNumber(list: List<Int>){
        if (list.size >8){
            list.forEach{
                phoneNumber += it.toString()
            }
            state.postValue(SmsOtpFragmentVS.SmsOtpPhoneNumber(phoneNumber))
        }else{
            list.forEach{
                pinNumber += it.toString()
            }
            state.postValue(SmsOtpFragmentVS.SmsOtpCode(pinNumber))
        }

    }
}