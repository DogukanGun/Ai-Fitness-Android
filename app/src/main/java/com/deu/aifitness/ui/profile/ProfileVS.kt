package com.deu.aifitness.ui.profile

import com.deu.aifitness.application.AIFitnessState

sealed class ProfileVS: AIFitnessState {
    object PositiveResponse: ProfileVS()
    object NegativeResponse: ProfileVS()
}