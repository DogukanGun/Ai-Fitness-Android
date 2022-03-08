package com.deu.aifitness.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.profile.Profile
import com.deu.aifitness.data.profile.ProfileEntity
import com.deu.aifitness.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : AIFitnessFragment<ProfileVM,FragmentProfileBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun getLayoutVM(): ProfileVM = profileVM

    @Inject
    lateinit var profileVM: ProfileVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  super.onCreateView(inflater, container, savedInstanceState)
        viewModel?.getProfile()
        binding?.editButtonBTN?.setOnClickListener(buttonListener)
        return view
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            is ProfileVS.SetProfile ->{
                setProfile(state.profile)
            }
            ProfileVS.PositiveResponse ->{
                viewModel?.getProfile()
            }
            ProfileVS.NegativeResponse ->{
                showNetworkError()
            }
        }
    }

    private fun setProfile(profile: ProfileEntity){
        binding?.emailAET?.setText(profile.email)
        binding?.phoneAET?.setText(profile.phoneNumber)
    }

    private val buttonListener = object :View.OnClickListener{
        override fun onClick(v: View?) {
            val newProfile = ProfileEntity( "",binding?.phoneAET?.getText() ?: ""
            ,binding?.emailAET?.getText() ?: "")
            viewModel?.updateProfile(newProfile)
        }
    }
}