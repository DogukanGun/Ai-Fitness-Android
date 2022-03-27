package com.deu.aifitness.network

import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.profile.*
import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.data.workout.UploadWorkoutRequest
import com.deu.aifitness.data.workout.Workout
import retrofit2.http.Body
import retrofit2.http.Query

interface ApiSource {

    fun registerUser(user:RegisterUser): Observable<RegisterUserResponse>
    fun loginUser(user:LoginUser): Observable<LoginUserResponse>
    fun getAllWorkouts(): Observable<List<Workout>>
    fun updateProfile(user: UpdateProfileRequest): Observable<ProfileResponse>
    fun getProfile(user:UpdateProfileRequest): Observable<ProfileResponse>
    fun getWorkout(workoutName:String): Observable<List<Workout>>
    fun updateProfileImage(updatePhoto: UpdateProfileImageRequest): Observable<ProfileEntity>
    fun uploadWorkout( uploadWorkoutRequest: UploadWorkoutRequest): Observable<UploadWorkoutRequest>

}