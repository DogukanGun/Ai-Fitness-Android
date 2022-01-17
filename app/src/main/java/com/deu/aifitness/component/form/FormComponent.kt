package com.deu.aifitness.component.form

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.deu.aifitness.R
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.data.form.FormAttribute
import com.deu.aifitness.data.form.FormFields

open class FormComponent : ConstraintLayout {

    lateinit var binding: com.deu.aifitness.databinding.ComponentFormBinding
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

            submitButton.setOnClickListener { view->
                    val array = adapter.itemList
                    val formFields = FormFields.convertFromFormItem(array)
                    listener?.onFormSubmit(formFields)
            }
        }



    }

    private fun setComponent(attrs: AttributeSet?,userOperationValue:String) {
        if (userOperationValue == AppConstants.UserOperation.Login.value) {
            val itemList = listOf(
                FormItem(FormAttribute.EMAIL, ""),
                FormItem(FormAttribute.PASSWORD, "")
            )
            recycler(itemList)
            context.theme.obtainStyledAttributes(attrs, R.styleable.FormComponent, 0, 0)
                .apply {
                    binding.submitButton.text = getString(R.styleable.FormComponent_loginButton)
                }

        } else {
            val itemList = listOf(
                FormItem(FormAttribute.EMAIL, ""),
                FormItem(FormAttribute.NAME, ""),
                FormItem(FormAttribute.SURNAME, ""),
                FormItem(FormAttribute.PASSWORD, ""),
                FormItem(FormAttribute.PASSWORDCONFIRM, "")
            )
            recycler(itemList)
            context.theme.obtainStyledAttributes(attrs, R.styleable.FormComponent, 0, 0)
                .apply {
                    binding.submitButton.text = getString(R.styleable.FormComponent_registerButton)
                }
        }
    }

    private fun recycler(itemList: List<FormItem>){
        adapter = FormAdapter(itemList)
        binding.rvRegister.adapter = adapter
        binding.rvRegister.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL ,false)
    }


}