package com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoaderViewModel: ViewModel() {

    private val _isPopupShown = MutableLiveData<Boolean>()
    val isPopupShown: LiveData<Boolean>
        get() = _isPopupShown

    init {
        // Initialize the LiveData
        _isPopupShown.value = false
    }

    fun setPopupShown() {
        // Set the value to true when the popup is shown
        _isPopupShown.value = true
    }
}