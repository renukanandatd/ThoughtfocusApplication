package com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.thoughtfocusapplication.roomdb.dao.TransactionDetailsDAO
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity
import com.example.thoughtfocusapplication.userinterface.adapters.ItemAdapter

class HistoryViewModel : ViewModel() {
    // TODO: Implement the ViewModel
}

private fun setupListOfDataIntoRecyclerView(transactionList:ArrayList<TransactionDetailsEntity>,
                                            transactionDetailsDAO: TransactionDetailsDAO
){
    if(transactionList.isNotEmpty()){
        val itemAdapter = ItemAdapter(transactionList

        )

    }
}