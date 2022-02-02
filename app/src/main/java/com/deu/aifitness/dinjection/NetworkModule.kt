package com.deu.aifitness.dinjection

import com.deu.aifitness.data.constant.ConnectionType
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.network.ApiServiceImpl
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.retrofit.ApiLogger
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideApiSource(retrofit: Retrofit):ApiSource = ApiServiceImpl(retrofit)

    @Provides
    fun provideRetrofit(): Retrofit {
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

}