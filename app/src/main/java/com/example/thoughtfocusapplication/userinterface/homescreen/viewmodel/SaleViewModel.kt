package com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thoughtfocusapplication.roomdb.TransactionApp
import com.example.thoughtfocusapplication.roomdb.dao.TransactionDetailsDAO
import com.example.thoughtfocusapplication.roomdb.db.ThoughtfocusDataBase
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class SaleViewModel : ViewModel() {
    val amount = MutableLiveData<String>()
    val transactionType = MutableLiveData<String>()
    val  date= MutableLiveData<String>()
    val  time= MutableLiveData<String>()

    fun addRecord(amount: String, transactionDetailsDAO: TransactionDetailsDAO) {
        if (amount.isNotEmpty()) {
            val currentDate = getCurrentDate()
            viewModelScope.launch {
                transactionDetailsDAO.insert(TransactionDetailsEntity(type = "Sale", amount=amount, date = currentDate))
            }
        }
    }

    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(Date())
    }

    fun getCurrentTime(): String {
        val timeFormat = SimpleDateFormat("HH:mm:ss")
        return timeFormat.format(Date())
    }

}