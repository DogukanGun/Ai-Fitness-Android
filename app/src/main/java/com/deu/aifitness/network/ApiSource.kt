package com.deu.aifitness.network

import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse

interface ApiSource {

    fun registerUser(user:RegisterUser): Observable<RegisterUserResponse>
}