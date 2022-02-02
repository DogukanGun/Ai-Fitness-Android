package com.deu.aifitness.ui.mainactivity

import com.deu.aifitness.application.AIFitnessState

sealed class MainActivityVS:AIFitnessState {
    object StartActivity:MainActivityVS()
}