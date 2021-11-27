package com.deu.aifitness.network

import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import retrofit2.Retrofit
import retrofit2.http.Body

class ApiServiceImpl(retrofit:Retrofit): ApiSource {
    private val apiService:ApiService = retrofit.create(ApiService::class.java)
    override fun registerUser(@Body user: RegisterUser):Observable<RegisterUserResponse> {
       return  apiService.registerUser(user)
    }
}