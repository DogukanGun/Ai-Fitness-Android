package com.deu.aifitness.component.aitextinput

import android.view.KeyEvent

interface AITextInputListener {
    fun textChange(newText: String)
    fun buttonPressed(keyEvent: KeyEvent)
}