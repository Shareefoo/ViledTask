package com.shareefoo.viledtask.ui.main

import androidx.lifecycle.*
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.data.model.GeneralResponse
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.repository.GeneralRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait

/**
 * MainViewModel designed to store and manage UI-related data in a lifecycle conscious way. This
 * allows data to survive configuration changes such as screen rotations. In addition, background
 * work such as fetching network results can continue through configuration changes and deliver
 * results after the new Fragment or Activity is available.
 *
 * @param generalRepository the data source this ViewModel will fetch data from.
 */
class MainViewModel(private val generalRepository: GeneralRepository) : ViewModel() {

    var servicesList = MutableLiveData<List<Service>>()
    var categoriesList = MutableLiveData<List<Category>>()

    // Show a loading spinner if true
    val spinner = MutableLiveData<Boolean>(false)

    fun setServices(services: List<Service>) {
        servicesList.value = services
    }

    fun setCategories(categories: List<Category>) {
        categoriesList.value = categories
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

//    // Do an asynchronous operation to fetch services.
//    // Todo: we can add try catch here to handle exceptions and errors
//    fun getGeneralResponse(): MutableLiveData<GeneralResponse> {
//        var response = MutableLiveData<GeneralResponse>()
//        viewModelScope.launch {
//            spinner.postValue(true)
//            response = generalRepository.getGeneralResponse()
//        }
//        return response
//    }

    fun getGeneralResponse() = liveData(Dispatchers.IO){
        spinner.postValue(true)
        val response = generalRepository.getGeneralResponse()
        emit(response)
    }

}