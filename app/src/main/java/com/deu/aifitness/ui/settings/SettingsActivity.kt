package com.deu.aifitness.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.databinding.ActivitySettingsBinding
import javax.inject.Inject

class SettingsActivity : AIFitnessActivity<SettingsVM,ActivitySettingsBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_settings

    override fun getLayoutVM(): SettingsVM = settingsVM

    override fun hasBackButton(): Boolean = true

    @Inject
    lateinit var settingsVM: SettingsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppBar()
        addFragment(SettingsFragment())
    }

}