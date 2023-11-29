package com.example.thoughtfocusapplication.roomdb

import android.app.Application
import com.example.thoughtfocusapplication.roomdb.db.ThoughtfocusDataBase

class TransactionApp:Application() {
    val db by lazy{
        ThoughtfocusDataBase.getInstance(this)
    }
}