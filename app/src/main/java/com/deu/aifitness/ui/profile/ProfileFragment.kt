package com.deu.aifitness.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : AIFitnessFragment<ProfileVM,FragmentProfileBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun getLayoutVM(): ProfileVM = profileVM

    @Inject
    lateinit var profileVM: ProfileVM
}