package com.deu.aifitness.network

import com.deu.aifitness.data.constant.ConnectionType
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.profile.*
import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.data.workout.UploadWorkoutRequest
import com.deu.aifitness.data.workout.Workout
import com.deu.aifitness.retrofit.ApiLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import javax.inject.Inject


class ApiServiceImpl @Inject constructor(retrofit: Retrofit): ApiSource {

    private val apiService:ApiService = retrofit.create(ApiService::class.java)
    override fun registerUser(@Body user: RegisterUser):Observable<RegisterUserResponse> {
       return  apiService.registerUser(user)
    }

    override fun loginUser(user: LoginUser): Observable<LoginUserResponse> {
        return  apiService.loginUser(user)
    }

    override fun getAllWorkouts(): Observable<List<Workout>> {
        return apiService.getAllWorkouts()
    }

    override fun updateProfile(user: UpdateProfileRequest): Observable<ProfileResponse> {
        return apiService.updateProfile(user)
    }

    override fun getProfile(user: UpdateProfileRequest): Observable<ProfileResponse> {
        return apiService.getProfile(user)
    }

    override fun getWorkout(workoutName: String): Observable<List<Workout>> {
        return apiService.getWorkout(workoutName)
    }

    override fun updateProfileImage(updatePhoto: UpdateProfileImageRequest): Observable<ProfileEntity> {
        return apiService.updateProfileImage(updatePhoto)
    }

    override fun uploadWorkout(uploadWorkoutRequest: UploadWorkoutRequest): Observable<UploadWorkoutRequest> {
        return apiService.uploadWorkout(uploadWorkoutRequest)
    }
}
