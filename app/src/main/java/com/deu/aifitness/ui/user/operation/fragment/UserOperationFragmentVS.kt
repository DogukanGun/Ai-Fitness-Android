package com.deu.aifitness.ui.user.operation.fragment

import com.deu.aifitness.application.AIFitnessState

sealed class UserOperationFragmentVS:AIFitnessState {
    object UserOperationDone:UserOperationFragmentVS()
}