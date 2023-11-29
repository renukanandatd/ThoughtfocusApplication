package com.example.thoughtfocusapplication.roomdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDetailsDAO {

    @Insert
    suspend fun insert(transactionDetails: TransactionDetailsEntity)

    @Update
    suspend fun update(transactionDetails: TransactionDetailsEntity)

    @Delete
    suspend fun delete(transactionDetails: TransactionDetailsEntity)

    @Query("SELECT * FROM `transactionDetails`")
    fun fetchAllTransactionDetails():Flow<List<TransactionDetailsEntity>>

    @Query("SELECT * FROM `transactionDetails` where id=:id")
    fun fetchTransactionDetails(id:Int):Flow<TransactionDetailsEntity>
}