package com.deu.aifitness.dinjection

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.deu.aifitness.data.constant.ConnectionType
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.network.ApiServiceImpl
import com.deu.aifitness.network.ApiSource
import com.deu.aifitness.retrofit.ApiLogger
import com.deu.aifitness.retrofit.HttpRetrofitInterceptor
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
    fun provideRetrofit(context: Context): Retrofit {
        val logger = HttpLoggingInterceptor(ApiLogger())
        logger.level = HttpLoggingInterceptor.Level.BODY
        val interceptor = HttpRetrofitInterceptor()

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .collector(ChuckerCollector(context))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            .addInterceptor(logger)
            .addInterceptor(interceptor)
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