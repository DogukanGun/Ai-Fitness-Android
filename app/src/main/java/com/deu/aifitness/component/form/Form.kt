package com.deu.aifitness.component.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.form.FormFields
import com.deu.aifitness.databinding.ComponentFormBinding

class Form(var userOperation: AppConstants.UserOperation) : Fragment() {

    lateinit var binding:ComponentFormBinding


    var listener:FormListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.component_form,container,false)
        binding.apply {
                if(userOperation.value==AppConstants.UserOperation.Login.value ){
                    name.visibility=View.GONE
                    surname.visibility=View.GONE
                    email.visibility=View.GONE
                    birthday.visibility=View.GONE
                    submitButton.text=getText(R.string.register_button)

                }else{
                    name.visibility=View.VISIBLE
                    surname.visibility=View.VISIBLE
                    email.visibility=View.VISIBLE
                    birthday.visibility=View.VISIBLE
                    submitButton.text=getText(R.string.login_button)
                }
            submitButton.setOnClickListener { view->
                val formFields = FormFields(username.text.toString(),name.text.toString(),surname.text.toString(),password.text.toString(),birthday.text.toString(),email.text.toString())
                var list = listOf(formFields)
                listener?.onFormSubmit(list)
            }
        }
        return binding.root
    }

}