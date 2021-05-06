package com.shareefoo.viledtask.repository

import androidx.lifecycle.MutableLiveData
import com.shareefoo.viledtask.api.GeneralApiService
import com.shareefoo.viledtask.api.ServiceBuilder
import com.shareefoo.viledtask.data.model.GeneralResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GeneralRepositoryImpl() : GeneralRepository {

    // Service creation
    private val mGeneralApiService = ServiceBuilder.buildService(GeneralApiService::class.java)

    // with coroutines
    override suspend fun getGeneralResponse() = mGeneralApiService.getResponse()

//    // without coroutines
//    override fun getGeneralResponse(): MutableLiveData<GeneralResponse> {
//        val data = MutableLiveData<GeneralResponse>()
//        mGeneralApiService.getResponse()
//            .enqueue(object : Callback<GeneralResponse> {
//                override fun onResponse(
//                    call: Call<GeneralResponse>, response: Response<GeneralResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        data.postValue(response.body()!!)
//                    }
//                }
//
//                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
//                    t.printStackTrace()
//                }
//            })
//        return data
//    }

}