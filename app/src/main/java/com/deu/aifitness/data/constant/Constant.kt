package com.deu.aifitness.data.constant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.tabbar.TabbarMenu

object Constant {
    var localPort = "8080"
    val localApiUrl = "http://localhost:$localPort/"
    val hostApiUrl = "https://aifitnessdeu.herokuapp.com"
    var connectionType = ConnectionType.LOCAL
    val paramName = "p1"
    var userOperation = AppConstants.UserOperation.Login
    var mainActivityTabbarStatus = TabbarMenu.HOME
}