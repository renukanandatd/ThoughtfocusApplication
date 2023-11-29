package com.example.thoughtfocusapplication.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionDetails")
data class TransactionDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val amount : String = ""
)
