package com.deu.aifitness.network

import com.deu.aifitness.data.constant.ConnectionType
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.data.loginuser.LoginUser
import com.deu.aifitness.data.loginuser.LoginUserResponse
import com.deu.aifitness.data.registeruser.RegisterUser
import io.reactivex.Observable
import com.deu.aifitness.data.registeruser.RegisterUserResponse
import com.deu.aifitness.retrofit.ApiLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import javax.inject.Inject
//@Inject constructor(retrofit:Retrofit)
class ApiServiceImpl constructor(retrofit:Retrofit): ApiSource {
    companion object{
        private var apiServiceImpl:ApiServiceImpl = ApiServiceImpl(provideRetrofit())
        fun getInstance():ApiServiceImpl{
            return apiServiceImpl
        }
    }

    private val apiService:ApiService = retrofit.create(ApiService::class.java)
    override fun registerUser(@Body user: RegisterUser):Observable<RegisterUserResponse> {
       return  apiService.registerUser(user)
    }

    override fun loginUser(user: LoginUser): Observable<LoginUserResponse> {
        return  apiService.loginUser(user)
    }
}
private fun provideRetrofit():Retrofit{
    val logger = HttpLoggingInterceptor(ApiLogger())
    logger.level = HttpLoggingInterceptor.Level.BODY

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()
    var url = ""
    if (Constant.connectionType == ConnectionType.HOST){
        url = Constant.hostApiUrl
    }else if(Constant.connectionType == ConnectionType.LOCAL){
        url = Constant.localApiUrl
    }
    return Retrofit.Builder()
        .baseUrl(url)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}
