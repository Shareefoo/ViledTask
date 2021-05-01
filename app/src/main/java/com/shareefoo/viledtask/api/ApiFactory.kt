package com.shareefoo.viledtask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    val auth0Api: Retrofit
        get() = Retrofit.Builder().baseUrl("https://api-test.vlife.kz")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
}