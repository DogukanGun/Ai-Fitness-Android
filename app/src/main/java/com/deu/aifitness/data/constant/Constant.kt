package com.deu.aifitness.data.constant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deu.aifitness.application.AppConstants
import com.deu.aifitness.data.tabbar.TabbarMenu

object Constant {
    var localPort = "8080"
    val localApiUrl = "https://aifitness-api.azurewebsites.net/"
    val hostApiUrl = "https://aifitness-api.azurewebsites.net/"
    var connectionType = ConnectionType.LOCAL
    val paramName = "p1"
    var userOperation = AppConstants.UserOperation.Login
    var mainActivityTabbarStatus = TabbarMenu.HOME
    val REQUEST_CAMERA_CODE_PERMISSIONS = 1234
    const val TAG = "CameraXApp"
    const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
}