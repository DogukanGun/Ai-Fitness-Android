package com.deu.aifitness.ui.user.operation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.component.form.Form
import com.deu.aifitness.component.form.FormListener
import com.deu.aifitness.data.form.FormFields
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.databinding.FragmentUserOperationBinding
import com.deu.aifitness.ui.user.operation.UserOperationState
import com.deu.aifitness.ui.user.operation.UserOperationVM
import javax.inject.Inject

class UserOperationFragment : Fragment() {

    lateinit var binding: FragmentUserOperationBinding

    @Inject
    lateinit var viewModel:UserOperationVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_operation, container,
                false)
        createForm()
        return binding.root
    }

    val formListener=object :FormListener{
        override fun onFormSubmit(list: FormFields) {
            if(UserOperationState.currentStatus==AppConstants.UserOperation.Register){
                val registerUser = RegisterUser(list.name,list.surname,list.username,list.email,
                    list.phone,list.password,list.birthday)
                viewModel.registerUser(registerUser)
            }else{
                val loginUser=LoginUser(list.username,list.password)
                viewModel.loginUser(loginUser)
            }

        }

    }
    private fun createForm() {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        val form = Form(UserOperationState.currentStatus)
        form.listener=formListener
        fragmentTransaction.add(binding.fragmentContainerView2.id, form)
        fragmentTransaction.commit()
    }


}