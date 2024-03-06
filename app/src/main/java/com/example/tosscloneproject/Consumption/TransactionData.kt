package com.example.tosscloneproject.Consumption

import android.view.SurfaceControl.Transaction

data class TransactionData(
    val id: Int,
    val amount: Long,
    val transactionType: String,
    val description: String,
    val depositDestination: BankAccount,
    val withdrawalDestination: BankAccount,
    val transactionTime: String,
    val balanceAfterTransaction: Long
)

data class BankAccount(
    val bank: String,
    val name: String,
    val bankAccountNumber: Long
)

data class ResponseBody(
    val httpStatus: String,
    val message: String,
    val data: Data
) {
    data class Data(
        val totalSpent: Long,
        val historyList: List<TransactionData>
    )
}

