package com.deu.aifitness.component.form

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.form.FormFields
import com.deu.aifitness.databinding.ComponentFormBinding

class Form(var userOperation: AppConstants.UserOperation=AppConstants.UserOperation.Register) : Fragment() {

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
                    phone.visibility=View.GONE
                    logo.visibility=View.VISIBLE
                    appname.visibility=View.VISIBLE
                    remembermelayout.visibility=View.VISIBLE
                    forgotpassword.visibility=View.VISIBLE
                    submitButton.text=getText(R.string.login_button)
                }else{
                    name.visibility=View.VISIBLE
                    surname.visibility=View.VISIBLE
                    email.visibility=View.VISIBLE
                    birthday.visibility=View.VISIBLE
                    phone.visibility=View.VISIBLE
                    logo.visibility=View.GONE
                    appname.visibility=View.GONE
                    remembermelayout.visibility=View.GONE
                    forgotpassword.visibility=View.GONE
                    submitButton.text=getText(R.string.register_button)
                }
            phone.addTextChangedListener(phoneWatcher)
            submitButton.setOnClickListener { view->
                val formFields = FormFields(username.text.toString(),name.text.toString(),
                    surname.text.toString(),password.text.toString(),birthday.text.toString(),
                    email.text.toString(),phone.text.toString())
                listener?.onFormSubmit(formFields)
            }
        }
        return binding.root
    }

    val filter = object: InputFilter {
        override fun filter(
            p0: CharSequence?,
            p1: Int,
            p2: Int,
            p3: Spanned?,
            p4: Int,
            p5: Int
        ): CharSequence {
            if (p0 != null){
                if(!p0.isDigitsOnly()){
                    return p0
                }
                return ""
            }
            return ""

        }

    }
    val phoneWatcher=object:TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (p0?.length==2){
                binding.phone.text.insert(0,"(")
            }else if( p0?.length==5){
                binding.phone.text.insert(5,") (")
            }else if( p0?.length==11){
                binding.phone.text.insert(11,") ")
            }else if(p0?.length==15){
                binding.phone.text.insert(15," ")
            }
        }

        override fun afterTextChanged(p0: Editable?) {

            if(p0 != null){
                if(p0.length>18){
                    p0.replace(18,19,"")
                }
            }

        }

    }
}