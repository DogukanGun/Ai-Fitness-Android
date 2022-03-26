package com.deu.aifitness.ui.smsotp

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.component.numpad.NumpadListener
import com.deu.aifitness.component.numpad.PinNumberType
import com.deu.aifitness.databinding.FragmentSmsOtpBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SmsOtpFragment : AIFitnessFragment<SmsOtpFragmentVM,FragmentSmsOtpBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_sms_otp

    override fun getLayoutVM(): SmsOtpFragmentVM = smsOtpFragmentVM

    @Inject
    lateinit var smsOtpFragmentVM: SmsOtpFragmentVM

    private var mVerificationId: String? = null
    private var mResendToken: ForceResendingToken? = null

    private var phoneNumber = ""

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
                showErrorProgress()
                (activity as AIFitnessActivity<*,*>).finish()
            }
            is SmsOtpFragmentVS.SmsOtpPhoneNumber ->{
                showProgress()
                binding?.pinNumberPN?.pinNumberType = PinNumberType.PIN
                binding?.pinNumberPN?.changeUI()
                phoneNumber = state.phoneNumber
                smsOtpSend()
            }
            is SmsOtpFragmentVS.SmsOtpCode ->{
                showProgress()
                controlWithCode(state.code)
            }
        }
    }

    private fun controlWithCode(code:String){
        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }

    private val mCallbacks = object : OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }
        }

        override fun onCodeSent(
            verificationId: String,
            token: ForceResendingToken
        ) {
            // Save verification ID and resending token so we can use them later
            mVerificationId = verificationId
            mResendToken = token
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        getFirebaseAuth()!!.signInWithCredential(credential)
            .addOnCompleteListener(getAIFitnessActivity()!!,
                OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        getAIFitnessActivity()?.firebaseUser = task.result.user
                        finishActivityWithResult(Intent().apply {
                            putExtra(Intent.EXTRA_RETURN_RESULT,RESULT_OK)
                        })
                    } else {
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            // The verification code entered was invalid
                        }
                    }
                })
    }

    private fun smsOtpSend(){
        val options = getFirebaseAuth()?.let {
            PhoneAuthOptions.newBuilder(it)
                .setPhoneNumber("+90$phoneNumber") // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(getAIFitnessActivity()!!) // Activity (for callback binding)
                .setCallbacks(mCallbacks) // OnVerificationStateChangedCallbacks
                .build()
        }
        if (options != null) {
            PhoneAuthProvider.verifyPhoneNumber(options)
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
                showProgress()
                viewModel?.postNumber(it)
            }
        }
    }
}