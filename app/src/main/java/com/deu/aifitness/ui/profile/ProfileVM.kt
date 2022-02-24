package com.deu.aifitness.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.application.AIFitnessVM
import com.deu.aifitness.data.profile.Profile
import com.deu.aifitness.data.profile.ProfileEntity

class ProfileVM:AIFitnessVM() {
    var profile = MutableLiveData(ProfileEntity("","",""))

    fun getProfile(){

    }
}