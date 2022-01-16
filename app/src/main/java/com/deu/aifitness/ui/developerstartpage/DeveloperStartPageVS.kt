package com.deu.aifitness.ui.developerstartpage

import com.deu.aifitness.application.AIFitnessState

sealed class DeveloperStartPageVS :AIFitnessState{
    object EnvironmentChangeToHost:DeveloperStartPageVS()
    object EnvironmentChangeToLocal:DeveloperStartPageVS()
    object StartProgram:DeveloperStartPageVS()

}