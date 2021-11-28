package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import retrofit2.Retrofit
import retrofit2.http.Body
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(retrofit:Retrofit): ApiSource {
    private val apiService:ApiService = retrofit.create(ApiService::class.java)
    override fun registerUser(@Body user: RegisterUser):Observable<RegisterUserResponse> {
       return  apiService.registerUser(user)
    }

    override fun loginUser(user: LoginUser): Observable<LoginUserResponse> {
        return  apiService.loginUser(user)
    }
}