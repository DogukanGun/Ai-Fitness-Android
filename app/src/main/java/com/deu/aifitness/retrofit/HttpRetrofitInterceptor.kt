package com.deu.aifitness.retrofit

import com.deu.aifitness.data.constant.Constant
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer

class HttpRetrofitInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestWithUrl = request.newBuilder()
            .url(request.url.toString())
            .build()
        return chain.proceed(createRequest(requestWithUrl))
    }

    private fun createRequest(request: Request):Request{
        val buffer = Buffer()
        request.body?.writeTo(buffer)
        return request.newBuilder()
            .header("accept","*/*")
            .header("Authorization", Constant.token)
            .method(request.method,request.body)
            .build()

    }
}