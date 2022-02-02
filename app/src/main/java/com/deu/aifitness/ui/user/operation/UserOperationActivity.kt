package com.deu.aifitness.ui.user.operation

import android.os.Bundle
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessActivity
import com.deu.aifitness.databinding.ActivityUserOperationBinding
import com.deu.aifitness.ui.user.operation.fragment.UserOperationFragment
import javax.inject.Inject

class UserOperationActivity : AIFitnessActivity<UserOperationVM,ActivityUserOperationBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_user_operation

    override fun getLayoutVM(): UserOperationVM = UserOperationVM()

    @Inject
    lateinit var userOperationVM: UserOperationVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(UserOperationFragment())
    }
}