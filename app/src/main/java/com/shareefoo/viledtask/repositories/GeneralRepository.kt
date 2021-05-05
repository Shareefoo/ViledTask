package com.shareefoo.viledtask.repositories

import androidx.lifecycle.MutableLiveData
import com.shareefoo.viledtask.api.GeneralApiService
import com.shareefoo.viledtask.api.ServiceBuilder
import com.shareefoo.viledtask.data.model.GeneralResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


interface GeneralRepository {

    fun getGeneralResponse(): MutableLiveData<GeneralResponse>

}