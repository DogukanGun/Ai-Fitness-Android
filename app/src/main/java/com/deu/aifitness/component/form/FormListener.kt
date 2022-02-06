package com.deu.aifitness.component.form

import android.widget.EditText
import com.deu.aifitness.data.form.AlternativeOperation
import com.deu.aifitness.data.form.FormFields

interface FormListener {

    fun onFormSubmit(list:FormFields)

    fun alternativeOperationPressed(alternativeOperation: AlternativeOperation)
}