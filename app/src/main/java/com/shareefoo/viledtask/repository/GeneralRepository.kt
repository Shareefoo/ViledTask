package com.shareefoo.viledtask.repository

import androidx.lifecycle.MutableLiveData
import com.shareefoo.viledtask.data.model.GeneralResponse

interface GeneralRepository {
    fun getGeneralResponse(): MutableLiveData<GeneralResponse>
}