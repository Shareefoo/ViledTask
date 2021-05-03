package com.shareefoo.viledtask.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shareefoo.viledtask.api.GeneralApiService
import com.shareefoo.viledtask.api.ServiceBuilder
import com.shareefoo.viledtask.models.GeneralResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GeneralRepository() {

    // Service creation
    private val mGeneralApiService = ServiceBuilder.buildService(GeneralApiService::class.java)

    fun getGeneralResponse(): MutableLiveData<GeneralResponse> {

        val data = MutableLiveData<GeneralResponse>()
        mGeneralApiService.getResponse()
            .enqueue(object : Callback<GeneralResponse> {
                override fun onResponse(
                    call: Call<GeneralResponse>, response: Response<GeneralResponse>
                ) {
                    if (response.isSuccessful) {
                        data.postValue(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        return data
    }

}