package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/register")
    fun registerUser(@Body user:RegisterUser): Observable<RegisterUserResponse>


    @POST("auth/login")
    fun loginUser(@Body user: LoginUser): Observable<LoginUserResponse>
}