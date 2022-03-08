package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.profile.Profile
import com.deu.aifitness.data.profile.ProfileEntity
import com.deu.aifitness.data.profile.ProfileResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.data.workout.Workout
import retrofit2.http.Body
import retrofit2.http.Query

interface ApiSource {

    fun registerUser(user:RegisterUser): Observable<RegisterUserResponse>
    fun loginUser(user:LoginUser): Observable<LoginUserResponse>
    fun getAllWorkouts(): Observable<List<Workout>>
    fun updateProfile(user: ProfileEntity): Observable<ProfileResponse>
    fun getProfile(user:ProfileEntity): Observable<ProfileResponse>
    fun getWorkout(workoutName:String): Observable<List<Workout>>

}