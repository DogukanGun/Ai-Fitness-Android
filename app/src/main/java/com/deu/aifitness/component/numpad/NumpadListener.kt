package com.deu.aifitness.component.numpad

interface NumpadListener {

    fun buttonPressed(buttonValue:Int)

    fun deleteButtonPressed()

    fun enterButtonPressed()
}