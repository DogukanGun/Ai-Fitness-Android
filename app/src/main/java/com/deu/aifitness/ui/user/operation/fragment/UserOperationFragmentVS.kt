package com.deu.aifitness.ui.user.operation.fragment

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.form.AlternativeOperation

sealed class UserOperationFragmentVS:AIFitnessState {
    object UserOperationDone:UserOperationFragmentVS()
    class StartLauncher(val alternativeOperation: AlternativeOperation):UserOperationFragmentVS()
}