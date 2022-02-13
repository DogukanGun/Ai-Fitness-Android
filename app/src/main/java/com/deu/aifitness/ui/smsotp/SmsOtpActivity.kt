package com.deu.aifitness.ui.smsotp

import android.os.Bundle
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.databinding.ActivitySmsOtpBinding
import javax.inject.Inject

class SmsOtpActivity : AIFitnessActivity<SmsOtpVM,ActivitySmsOtpBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_sms_otp

    override fun getLayoutVM(): SmsOtpVM = smsOtpVM

    @Inject
    lateinit var smsOtpVM: SmsOtpVM

    override fun hasBackButton(): Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppBar()
        addFragment(SmsOtpFragment())
    }
}