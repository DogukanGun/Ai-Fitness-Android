package com.deu.aifitness.ui.user.operation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.component.form.FormListener
import com.deu.aifitness.data.form.FormFields
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.databinding.FragmentUserOperationBinding
import com.deu.aifitness.ui.homepage.HomeFragment
import com.deu.aifitness.ui.user.operation.UserOperationState
import javax.inject.Inject

class UserOperationFragment
    : AIFitnessFragment<UserOperationFragmentVM,FragmentUserOperationBinding>(){

    @Inject
    lateinit var userOperationFragmentVM:UserOperationFragmentVM

    override fun getLayoutId(): Int = R.layout.fragment_user_operation

    override fun getLayoutVM(): UserOperationFragmentVM = userOperationFragmentVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding?.form?.listener = formListener
        return view
    }


    val formListener=object : FormListener {
        override fun onFormSubmit(list: FormFields) {
            if(UserOperationState.currentStatus==AppConstants.UserOperation.Register){
                val registerUser = RegisterUser(list.name,list.surname,list.username,list.email,
                    list.phone,list.password,list.birthday)
                viewModel?.registerUser(registerUser)
            }else{
                val loginUser=LoginUser(list.username,list.password)
                viewModel?.loginUser(loginUser)
            }

        }

    }
}