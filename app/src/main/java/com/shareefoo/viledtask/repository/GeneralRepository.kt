package com.shareefoo.viledtask.repository

import androidx.lifecycle.MutableLiveData
import com.shareefoo.viledtask.data.model.GeneralResponse

interface GeneralRepository {
    suspend fun getGeneralResponse(): GeneralResponse
}