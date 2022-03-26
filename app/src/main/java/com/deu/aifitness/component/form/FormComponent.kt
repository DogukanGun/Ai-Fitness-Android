package com.deu.aifitness.component.form

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.deu.aifitness.databinding.ComponentFormBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.data.form.AlternativeOperation
import com.deu.aifitness.data.form.FormAttribute
import com.deu.aifitness.data.form.FormFields
import com.facebook.login.widget.LoginButton

open class FormComponent : ConstraintLayout {

    lateinit var binding: ComponentFormBinding
    var otherOptions = MutableLiveData<Boolean>(false)
    lateinit var adapter: FormAdapter
    var listener: FormListener? = null

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.component_form,
            this,
            true
        )
        binding.apply {
            setComponent(attrs, Constant.userOperation.value)
            submitButtonBTN.setOnClickListener { view->
                    val array = adapter.itemList
                    val formFields = FormFields.convertFromFormItem(array)
                    listener?.onFormSubmit(formFields)
            }
            gmailProcessIB.setOnClickListener {
                listener?.alternativeOperationPressed(AlternativeOperation.GOOGLE)
            }
            googlePlayProcessIB.setOnClickListener {
                listener?.alternativeOperationPressed(AlternativeOperation.PHONE)
            }
        }
    }
    private fun setComponent(attrs: AttributeSet?,userOperationValue:String) {
        if (userOperationValue == AppConstants.UserOperation.Login.value) {
            val itemList = listOf(
                FormItem(FormAttribute.USERNAME, ""),
                FormItem(FormAttribute.PASSWORD, "")
            )
            recycler(itemList)
            context.theme.obtainStyledAttributes(attrs, R.styleable.FormComponent, 0, 0)
                .apply {
                    binding.submitButtonBTN.text = getString(R.styleable.FormComponent_loginButton)
                    otherOptions.postValue(getBoolean(R.styleable.FormComponent_otherOptions,false))
                }

        } else {
            val itemList = listOf(
                FormItem(FormAttribute.NAME, ""),
                FormItem(FormAttribute.USERNAME, ""),
                FormItem(FormAttribute.EMAIL, ""),
                FormItem(FormAttribute.PASSWORD, ""),
            )
            recycler(itemList)
            context.theme.obtainStyledAttributes(attrs, R.styleable.FormComponent, 0, 0)
                .apply {
                    binding.submitButtonBTN.text = getString(R.styleable.FormComponent_registerButton)
                    otherOptions.postValue(getBoolean(R.styleable.FormComponent_otherOptions,false))
                }
        }
    }

    private fun recycler(itemList: List<FormItem>){
        adapter = FormAdapter(itemList)
        binding.registerRV.adapter = adapter
        binding.registerRV.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL ,false)
    }


}