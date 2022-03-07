package com.deu.aifitness.application

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deu.aifitness.component.dialog.AIFitnessDialog
import com.deu.aifitness.component.dialog.AIFitnessDialogListener
import com.deu.aifitness.component.dialog.DialogButton
import com.deu.aifitness.component.dialog.DialogContent
import com.deu.aifitness.ui.developerstartpage.DeveloperStartPageVS

open class AIFitnessVM:ViewModel(){
    val state = MutableLiveData<AIFitnessState>()
}