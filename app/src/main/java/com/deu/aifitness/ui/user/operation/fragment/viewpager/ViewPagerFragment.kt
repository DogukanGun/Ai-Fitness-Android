package com.deu.aifitness.ui.user.operation.fragment.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.component.form.FormListener
import com.deu.aifitness.data.form.AlternativeOperation
import com.deu.aifitness.data.form.FormFields
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.databinding.FragmentViewPagerBinding
import javax.inject.Inject

class ViewPagerFragment : AIFitnessFragment<ViewPagerVM,FragmentViewPagerBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_view_pager

    override fun getLayoutVM(): ViewPagerVM = viewPagerVM

    lateinit var userOperationStatus:AppConstants.UserOperation

    @Inject
    lateinit var viewPagerVM: ViewPagerVM

    var listener:ViewPagerListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  super.onCreateView(inflater, container, savedInstanceState)
        binding?.form?.listener = formListener
        return view
    }

    private val formListener=object : FormListener {
        override fun onFormSubmit(list: FormFields) {
            if(userOperationStatus== AppConstants.UserOperation.Register){
                val registerUser = RegisterUser(list.name,list.surname,list.username,list.email,
                    list.phone,list.password,list.birthday)
                listener?.registerUser(registerUser)
            }else{
                val loginUser= LoginUser(list.email,list.password)
                listener?.loginUser(loginUser)
            }
        }

        override fun alternativeOperationPressed(alternativeOperation: AlternativeOperation) {
            if(userOperationStatus== AppConstants.UserOperation.Register){
                listener?.alternativeRegisterPressed(alternativeOperation)
            }else{
                listener?.alternativeLoginPressed(alternativeOperation)
            }
        }
    }
}