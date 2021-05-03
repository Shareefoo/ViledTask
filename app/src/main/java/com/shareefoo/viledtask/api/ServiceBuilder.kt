package com.shareefoo.viledtask.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("Accept-Language", "en")
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api-test.vlife.kz")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

}