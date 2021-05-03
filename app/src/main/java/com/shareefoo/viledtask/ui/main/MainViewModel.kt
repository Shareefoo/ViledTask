package com.shareefoo.viledtask.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shareefoo.viledtask.models.GeneralResponse
import com.shareefoo.viledtask.repositories.GeneralRepository

class MainViewModel(var generalRepository: GeneralRepository) : ViewModel() {

    fun getGeneralResponse(): MutableLiveData<GeneralResponse> {
        return generalRepository.getGeneralResponse()
    }

}