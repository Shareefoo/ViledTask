package com.shareefoo.viledtask.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.data.model.GeneralResponse
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.repositories.GeneralRepository

class MainViewModel(private val generalRepository: GeneralRepository) : ViewModel() {

    var servicesList = MutableLiveData<List<Service>>()
    var categoriesList = MutableLiveData<List<Category>>()

    fun setServices(services: List<Service>) {
        servicesList.value = services
    }

    fun setCategories(categories: List<Category>) {
        categoriesList.value = categories
    }

    private val services: MutableLiveData<List<Service>> by lazy {
        MutableLiveData<List<Service>>().also {
            loadServices()
        }
    }

    fun getServices(): LiveData<List<Service>> {
        return services
    }

    private fun loadServices() {
        // Do an asynchronous operation to fetch services.
        val generalResponse = generalRepository.getGeneralResponse()
    }

    fun getServiceCategories(serviceId: String): List<Category> {
        val newList: ArrayList<Category> = ArrayList()

//        val categoriesIdList: List<String> = this.categoryIds
//        for (id in categoriesIdList) {
//            for (category in categories) {
//                if (id == category.id) {
//                    newList.add(category)
//                }
//            }
//        }

        return newList
    }

    fun getGeneralResponse(): MutableLiveData<GeneralResponse> {
        return generalRepository.getGeneralResponse()
    }

}