package com.deu.aifitness.component.aitextinput

import android.view.KeyEvent
import com.deu.aifitness.data.form.FormAttribute

interface AITextInputListener {
    fun textChange(newText: String,inputType:FormAttribute)
    fun buttonPressed(keyEvent: KeyEvent)
}