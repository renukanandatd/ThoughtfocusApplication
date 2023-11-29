package com.example.thoughtfocusapplication.roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thoughtfocusapplication.roomdb.dao.TransactionDetailsDAO
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity

@Database(entities = [TransactionDetailsEntity::class], version = 1)
abstract class ThoughtfocusDataBase:RoomDatabase() {

    abstract fun transactionDAO():TransactionDetailsDAO

    companion object {
        @Volatile
        private var INSTANCE: ThoughtfocusDataBase? = null

        fun getInstance(context: Context): ThoughtfocusDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ThoughtfocusDataBase::class.java,
                        name = "thoughtfocus_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}