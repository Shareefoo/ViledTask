package com.shareefoo.viledtask.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shareefoo.viledtask.repository.GeneralRepository

class MainViewModelFactory constructor(private val generalRepository: GeneralRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.generalRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}