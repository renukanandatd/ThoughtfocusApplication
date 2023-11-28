package com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SaleViewModel : ViewModel() {
    val sharedData = MutableLiveData<String>()
    var paymentType = String()
}