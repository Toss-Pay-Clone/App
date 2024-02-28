package com.example.tosscloneproject.Consumption

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Thread.State
import java.time.LocalDate

// ViewModel 통해 API 호출
@RequiresApi(Build.VERSION_CODES.O)
class TransactionViewModel(private val transactionApiService: TransactionApiService) : ViewModel() {
    private val _transactionDates = MutableStateFlow(emptyList<LocalDate>())
    val transactionDates: StateFlow<List<LocalDate>> = _transactionDates

    private val _transactions = MutableStateFlow(emptyList<TransactionData>())
    val transactions: StateFlow<List<TransactionData>> = _transactions

    val transactionDateSet = mutableStateOf(setOf<LocalDate>())
    val spentAmount = mutableStateOf(0L)

    // Graph에 사용
    val currentMonthSpentAmount = mutableStateOf(0L)
    val previousMonthSpentAmount = mutableStateOf(0L)
    val currentMonth = mutableStateOf(LocalDate.now().monthValue)

    init {
        loadTransactionDates(2024, 2)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadTransactionDates(year: Int, month: Int) {
        viewModelScope.launch {
            val cookie = "access_token=eyJhbGciOiJIUzI1NiJ9...; refresh_token=eyJhbGciOiJIUzI1NiJ9..."
            val response = transactionApiService.getTransactionHistory(year, month, cookie)
            _transactionDates.value = response.data.historyList.map {
                LocalDate.parse(it.transactionTime.substringBefore("T"))
            }
            _transactions.value = response.data.historyList
            transactionDateSet.value = transactionDates.value.toSet()
            spentAmount.value = response.data.historyList.sumOf { it.amount }

            // Graph
            if (month == currentMonth.value) {
                currentMonthSpentAmount.value = response.data.historyList.sumOf { it.amount }
            } else if (month == currentMonth.value-1) {
                previousMonthSpentAmount.value = response.data.historyList.sumOf { it.amount }
            }
        }
    }
}

class TransactionViewModelFactory(private val transactionApiService: TransactionApiService) : ViewModelProvider.Factory {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            return TransactionViewModel(transactionApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


