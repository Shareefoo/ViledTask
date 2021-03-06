package com.shareefoo.viledtask.api

import com.shareefoo.viledtask.data.model.GeneralResponse
import retrofit2.Call
import retrofit2.http.GET

interface GeneralApiService {

    /**
     * @GET declares an HTTP GET request
     */
    @GET("/finance/service-catalog/v1/categories")
    suspend fun getResponse(): GeneralResponse
}