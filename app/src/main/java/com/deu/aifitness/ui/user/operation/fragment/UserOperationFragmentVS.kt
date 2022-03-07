package com.deu.aifitness.ui.user.operation.fragment

import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.form.AlternativeOperation
import com.deu.aifitness.data.loginuser.LoginUser

sealed class UserOperationFragmentVS:AIFitnessState {
    object UserOperationDone:UserOperationFragmentVS()
    class LoginUserComingFromRegister(val loginUser: LoginUser):UserOperationFragmentVS()
    class StartLauncher(val alternativeOperation: AlternativeOperation):UserOperationFragmentVS()
    object UserOperationError:UserOperationFragmentVS()
}