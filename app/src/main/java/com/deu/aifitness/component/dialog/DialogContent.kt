package com.deu.aifitness.component.dialog

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DialogContent (
    var buttonPositiveContext:DialogButton = DialogButton("Yes",true),
    var buttonNegativeContext:DialogButton? = DialogButton("No",true),
    var title:String? = null,
    var message:String? = null
): Parcelable