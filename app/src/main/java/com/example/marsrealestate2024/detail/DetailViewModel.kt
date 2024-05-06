package com.example.marsrealestate2024.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.marsrealestate2024.R
import com.example.marsrealestate2024.network.MarsProperty
import timber.log.Timber

class DetailViewModel(marsProperty: MarsProperty, application: Application) : ViewModel() {
    private var _selectedProperty = MutableLiveData<MarsProperty>()
    val selectedProperty: LiveData<MarsProperty>
        get() {
            return _selectedProperty
        }

    init {
        _selectedProperty.value = marsProperty
    }

    val displayProperyPrice = _selectedProperty.map { it ->
        application.applicationContext.getString(when(_selectedProperty.value!!.isRental) {
            true -> R.string.detail_price_month_rental
            false -> R.string.detail_price
        }, it.price)
    }

    val displayProperyType = _selectedProperty.map { it ->
        application.applicationContext.getString(R.string.detail_type,
            application.applicationContext.getString(when(it.isRental) {
                true -> R.string.detail_type_rent
                false -> R.string.detail_type_sale
            })
        )
    }

    override fun onCleared() {
        Timber.i("cleared")
        super.onCleared()
    }
}