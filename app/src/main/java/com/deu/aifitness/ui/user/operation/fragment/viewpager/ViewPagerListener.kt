package com.deu.aifitness.ui.user.operation.fragment.viewpager

import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.registeruser.RegisterUser

interface ViewPagerListener {
    fun registerUser(registerUser: RegisterUser)

    fun loginUser(loginUser: LoginUser)
}