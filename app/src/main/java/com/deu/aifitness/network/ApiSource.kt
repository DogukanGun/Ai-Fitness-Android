package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.profile.Profile
import com.deu.aifitness.data.profile.ProfileResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.data.workout.Workout
import retrofit2.http.Body

interface ApiSource {

    fun registerUser(user:RegisterUser): Observable<RegisterUserResponse>
    fun loginUser(user:LoginUser): Observable<LoginUserResponse>
    fun getAllWorkouts(): Observable<List<Workout>>
    fun updateProfile(@Body user: Profile): Observable<ProfileResponse>

}