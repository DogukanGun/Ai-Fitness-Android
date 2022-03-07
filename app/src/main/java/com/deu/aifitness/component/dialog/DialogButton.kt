package com.deu.aifitness.component.dialog

import android.graphics.Color
import android.os.Parcelable
import com.deu.aifitness.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DialogButton(var buttonText:String = "",
                        var buttonEnable:Boolean = false) :Parcelable
