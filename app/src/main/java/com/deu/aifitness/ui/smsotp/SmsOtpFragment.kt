package com.deu.aifitness.ui.smsotp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.component.numpad.NumpadListener
import com.deu.aifitness.databinding.FragmentSmsOtpBinding
import javax.inject.Inject


class SmsOtpFragment : AIFitnessFragment<SmsOtpFragmentVM,FragmentSmsOtpBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_sms_otp

    override fun getLayoutVM(): SmsOtpFragmentVM = smsOtpFragmentVM

    @Inject
    lateinit var smsOtpFragmentVM: SmsOtpFragmentVM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding?.numpadNP?.listener = numpadListener
        return view
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            SmsOtpFragmentVS.SuccessResult ->{
                finishActivityWithResult(Intent())
            }
            SmsOtpFragmentVS.FailedResult ->{
                (activity as AIFitnessActivity<*,*>).finish()
            }
        }
    }

    private val numpadListener = object :NumpadListener{
        override fun buttonPressed(buttonValue: Int) {
            binding?.pinNumberPN?.addNumber(buttonValue)
        }

        override fun deleteButtonPressed() {
            binding?.pinNumberPN?.deleteNumber()
        }

        override fun enterButtonPressed() {
            binding?.pinNumberPN?.getNumbers()?.let {
                viewModel?.postOtpCode(it)
            }
        }
    }
}