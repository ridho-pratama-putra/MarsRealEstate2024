package com.example.marsrealestate2024.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsrealestate2024.network.MarsApi
import com.example.marsrealestate2024.network.MarsApiFilter
import com.example.marsrealestate2024.network.MarsApiStatus
import com.example.marsrealestate2024.network.MarsProperty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class OverviewViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    private val _lodaingStatus = MutableLiveData<MarsApiStatus>()
    val loadingStatus: LiveData<MarsApiStatus>
        get() = _lodaingStatus

    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
    }

    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {
        Timber.d("starting Running on thread: ${Thread.currentThread().name}")
        _lodaingStatus.value = MarsApiStatus.LOADING
        Timber.d("MarsApiStatus.LOADING Running on thread: ${Thread.currentThread().name}")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = MarsApi.retrofitService.getProperties(filter.value)
                Timber.d("retrofitService Running on thread: ${Thread.currentThread().name}")
                withContext(Dispatchers.Main) {
                    _properties.value = result
                    _lodaingStatus.value = MarsApiStatus.DONE
                    Timber.d("MarsApiStatus.DONE Running on thread: ${Thread.currentThread().name}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _lodaingStatus.value = MarsApiStatus.ERROR
                    _properties.value = ArrayList()
                }
            }
            Timber.d("inside after all Running on thread: ${Thread.currentThread().name}")
        }
        Timber.d("outside after all Running on thread: ${Thread.currentThread().name}")

    }

    override fun onCleared() {
        Timber.i("onCleared")
        super.onCleared()
    }
}