package com.deu.aifitness.dinjection

import com.deu.aifitness.network.ApiServiceImpl
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.retrofit.ApiLogger
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        val logger = HttpLoggingInterceptor(ApiLogger())
        logger.level = HttpLoggingInterceptor.Level.BODY

        var httpClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://aifitnessdeu.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiSource(retrofit: Retrofit):ApiSource = ApiServiceImpl(retrofit)
}