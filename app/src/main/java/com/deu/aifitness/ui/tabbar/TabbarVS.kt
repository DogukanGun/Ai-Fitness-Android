package com.deu.aifitness.ui.tabbar

import com.deu.aifitness.application.AIFitnessState

sealed class TabbarVS:AIFitnessState {
    object Homepage:TabbarVS()
    object Exercise:TabbarVS()
    object Profile:TabbarVS()
}