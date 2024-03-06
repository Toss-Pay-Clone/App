package com.example.tosscloneproject.Transfer.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TransferAmountVM: ViewModel() {
    private val _amount = mutableStateOf("")
    val amount: State<String> = _amount

    fun setAmount(value: String) {
        _amount.value = value
    }
}

class TransferAmountVMFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransferAmountVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransferAmountVM() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}