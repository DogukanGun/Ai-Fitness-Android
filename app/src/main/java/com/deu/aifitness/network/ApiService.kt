package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import io.reactivex.Observable
import retrofit2.http.POST

interface ApiService {

    @POST("users/register")
    fun registerUser(user:RegisterUser): Observable<RegisterUserResponse>


    @POST("users/login")
    fun loginUser(user: LoginUser): Observable<LoginUserResponse>
}