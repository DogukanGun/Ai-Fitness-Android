package com.deu.aifitness.data.loginuser

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(
            @SerializedName("data")
            val token:String
)
