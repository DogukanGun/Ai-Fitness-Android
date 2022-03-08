package com.deu.aifitness.ui.profile

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.profile.Profile
import com.deu.aifitness.data.profile.ProfileEntity

sealed class ProfileVS: AIFitnessState {
    class SetProfile(val profile:ProfileEntity): ProfileVS()
    object PositiveResponse: ProfileVS()
    object NegativeResponse: ProfileVS()
}