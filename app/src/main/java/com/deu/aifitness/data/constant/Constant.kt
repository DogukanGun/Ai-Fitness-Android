package com.deu.aifitness.data.constant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.application.AppConstants

object Constant {
    var localPort = "8080"
    val localApiUrl = "http://localhost:$localPort/"
    val hostApiUrl = "https://aifitnessdeu.herokuapp.com"
    var connectionType = ConnectionType.LOCAL
    val paramName = "p1"
    var userOperation = AppConstants.UserOperation.Register
}