package com.deu.aifitness.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.databinding.FragmentSettingsBinding
import javax.inject.Inject

class SettingsFragment : AIFitnessFragment<SettingsFragmentVM,FragmentSettingsBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_settings

    override fun getLayoutVM(): SettingsFragmentVM = settingsFragmentVM

    @Inject
    lateinit var settingsFragmentVM: SettingsFragmentVM

}