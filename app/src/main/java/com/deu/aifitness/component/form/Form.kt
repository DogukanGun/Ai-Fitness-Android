package com.deu.aifitness.component.form

import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.form.FormAttribute
import com.deu.aifitness.data.form.FormFields
import com.deu.aifitness.databinding.ComponentFormBinding
import javax.inject.Inject

class Form(var userOperation: AppConstants.UserOperation=AppConstants.UserOperation.Register) :
    AIFitnessFragment<FormVM,ComponentFormBinding>() {

    override fun getLayoutId(): Int = R.layout.component_form

    override fun getLayoutVM(): FormVM = formVM

    @Inject
    lateinit var formVM:FormVM

    lateinit var adapter:FormAdapter

    var listener:FormListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        binding.let {
            it!!.apply {
                if(userOperation.value==AppConstants.UserOperation.Login.value ){
                    val itemList = listOf(
                        FormItem(FormAttribute.EMAIL,""),
                        FormItem(FormAttribute.PASSWORD,"")
                    )
                    recycler(itemList)
                    this!!.submitButton.text=getText(R.string.login_button)
                }else{
                    val itemList = listOf(
                        FormItem(FormAttribute.EMAIL,""),
                        FormItem(FormAttribute.NAME,""),
                        FormItem(FormAttribute.SURNAME,""),
                        FormItem(FormAttribute.PASSWORD,""),
                        FormItem(FormAttribute.PASSWORDCONFIRM,"")
                    )
                    recycler(itemList)
                    submitButton.text=getText(R.string.register_button)
                }

                submitButton.setOnClickListener { view->
                    val array = adapter.itemList
                    val formFields = FormFields.convertFromFormItem(array)
                    listener?.onFormSubmit(formFields)
                }
            }
        }
        return binding?.root
    }
    private fun recycler(itemList: List<FormItem>){
        adapter = FormAdapter(itemList)
        binding?.rvRegister?.adapter = adapter
        binding?.rvRegister?.layoutManager = LinearLayoutManager(requireContext(),
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