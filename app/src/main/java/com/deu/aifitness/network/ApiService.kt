package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.profile.*
import com.deu.aifitness.data.registeruser.RegisterUser
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.data.workout.Workout
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("auth/register")
    fun registerUser(@Body user:RegisterUser): Observable<RegisterUserResponse>

    @POST("auth/login")
    fun loginUser(@Body user: LoginUser): Observable<LoginUserResponse>

    @POST("workout/workout/all")
    fun getAllWorkouts(): Observable<List<Workout>>

    @POST("user/updateUser")
    fun updateProfile(@Body user: UpdateProfileRequest): Observable<ProfileResponse>

    @POST("user/getProfile")
    fun getProfile(@Body user:UpdateProfileRequest): Observable<ProfileResponse>

    @POST("user/updatephoto")
    fun updateProfileImage(@Body updatePhoto:UpdateProfileImageRequest): Observable<ProfileEntity>

    @POST("workout/workout/name/{name}")
    fun getWorkout(@Path("name") workoutName:String): Observable<List<Workout>>
}