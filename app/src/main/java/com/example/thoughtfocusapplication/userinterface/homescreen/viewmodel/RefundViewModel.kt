package com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thoughtfocusapplication.roomdb.dao.TransactionDetailsDAO
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class RefundViewModel : ViewModel() {
    val sharedData = MutableLiveData<String>()

    fun addRecord(amount: String, transactionDetailsDAO: TransactionDetailsDAO) {
        if (amount.isNotEmpty()) {
            val currentDate = getCurrentDate()
            viewModelScope.launch {
                transactionDetailsDAO.insert(TransactionDetailsEntity(type = "Refund", amount=amount, date = currentDate))
            }
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(Date())
    }

}