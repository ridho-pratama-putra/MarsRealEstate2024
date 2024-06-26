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
import kotlinx.coroutines.cancel
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

    private val _navigateToSelectedProperty = MutableLiveData<MarsProperty?>()

    val navigateToSelectedProperty: LiveData<MarsProperty?>
        get() = _navigateToSelectedProperty

    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
    }

    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {
        Timber.i("starting Running on thread: ${Thread.currentThread().name}")
        _lodaingStatus.value = MarsApiStatus.LOADING
        Timber.i("MarsApiStatus.LOADING Running on thread: ${Thread.currentThread().name}")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = MarsApi.retrofitService.getProperties(filter.value)
                Timber.i("retrofitService Running on thread: ${Thread.currentThread().name}")
                withContext(Dispatchers.Main) {
                    _properties.value = result
                    _lodaingStatus.value = MarsApiStatus.DONE
                    Timber.i("MarsApiStatus.DONE Running on thread: ${Thread.currentThread().name}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _lodaingStatus.value = MarsApiStatus.ERROR
                    _properties.value = ArrayList()
                }
            }
            Timber.i("inside after all Running on thread: ${Thread.currentThread().name}")
        }
        Timber.i("outside after all Running on thread: ${Thread.currentThread().name}")

    }

    override fun onCleared() {
        Timber.i("onCleared")
        super.onCleared()
        viewModelScope.cancel()
    }

    fun displayPropertyDetails(marsProperty: MarsProperty) {
        _navigateToSelectedProperty.value = marsProperty
    }

    fun onDisplayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}