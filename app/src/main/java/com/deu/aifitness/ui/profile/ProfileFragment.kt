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
import com.deu.aifitness.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : AIFitnessFragment<ProfileVM,FragmentProfileBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun getLayoutVM(): ProfileVM = profileVM

    @Inject
    lateinit var profileVM: ProfileVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.getProfile()
        binding?.editButtonBTN?.setOnClickListener(buttonListener)
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            ProfileVS.PositiveResponse ->{

            }
            ProfileVS.NegativeResponse ->{
                showNetworkError()
            }
        }
    }

    private val buttonListener = object :View.OnClickListener{
        override fun onClick(v: View?) {
            val newProfile = Profile(binding?.nameAET?.getText(),binding?.emailAET?.getText()
            ,binding?.phoneAET?.getText())
            viewModel?.updateProfile(newProfile)
        }
    }
}