package com.example.thoughtfocusapplication.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "")
data class TransactionDetails(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val amount : String = ""
)
