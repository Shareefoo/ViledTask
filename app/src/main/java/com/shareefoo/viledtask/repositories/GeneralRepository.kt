package com.shareefoo.viledtask.repositories

import androidx.lifecycle.MutableLiveData
import com.shareefoo.viledtask.api.ApiFactory
import com.shareefoo.viledtask.api.GeneralApiService
import com.shareefoo.viledtask.models.GeneralResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GeneralRepository(apiFactory: ApiFactory) {

    // Service creation
    private val mGeneralApiService = apiFactory.auth0Api.create(GeneralApiService::class.java)

    private var generalService: GeneralApiService? = null
    private var generalResponseLiveData: MutableLiveData<GeneralResponse>? = null

    fun getGeneralResponse(): MutableLiveData<GeneralResponse> {
        val data = MutableLiveData<GeneralResponse>()
        mGeneralApiService.getResponse()
            .enqueue(object : Callback<GeneralResponse> {
                override fun onResponse(
                    call: Call<GeneralResponse>, response: Response<GeneralResponse>
                ) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        return data
    }

}