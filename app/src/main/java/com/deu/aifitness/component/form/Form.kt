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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
                    var itemList = listOf(
                        Register("Email", "abcde@mail.com"),
                        Register("Password", "")
                    )
                    recycler(itemList)
                    submitButton.text=getText(R.string.login_button)
                }else{
                    var itemList = listOf(
                        Register("Email", "abcde@mail.com"),
                        Register("Name", ""),
                        Register("Surname", ""),
                        Register("Password", ""),
                        Register("Password Again", "")
                    )
                    recycler(itemList)
                    submitButton.text=getText(R.string.register_button)
                }

            /*submitButton.setOnClickListener { view->
                val formFields = FormFields(username.text.toString(),name.text.toString(),
                    surname.text.toString(),password.text.toString(),birthday.text.toString(),
                    email.text.toString(),phone.text.toString())
                listener?.onFormSubmit(formFields)
            }*/
        }
        return binding.root
    }
    private fun recycler(itemList: List<Register>){
        val adapter = RegisterAdapter(itemList)
        binding.rvRegister.adapter = adapter
        binding.rvRegister.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL ,false)
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

}