package com.deu.aifitness.ui.smsotp

import com.deu.aifitness.application.AIFitnessState

sealed class SmsOtpFragmentVS :AIFitnessState{
    object SuccessResult: SmsOtpFragmentVS()
    object FailedResult: SmsOtpFragmentVS()
    class SmsOtpPhoneNumber(val phoneNumber:String): SmsOtpFragmentVS()
    class SmsOtpCode(val code:String): SmsOtpFragmentVS()
}