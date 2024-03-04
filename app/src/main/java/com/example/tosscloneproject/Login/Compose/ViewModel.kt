package com.example.tosscloneproject.Login.Compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tosscloneproject.Login.Register.ResidentNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class PhoneNumberViewModel : ViewModel() {
    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber : StateFlow<String> = _phoneNumber

    fun setPhoneNumber (newPhone : String) {
        _phoneNumber.value = newPhone
    }
}


class UserNameViewModel : ViewModel() {
    private val _userName = MutableStateFlow("")
    val userName : StateFlow<String> = _userName

    fun setUserName (newName: String) {
        _userName.value = newName
    }
}

class BirthNumberViewModel : ViewModel() {
    private val _birthNumber = MutableStateFlow("")
    val birthNumber : StateFlow<String> = _birthNumber

    fun setBirthNumber (newBirth: String) {
        _birthNumber.value = newBirth
    }
}

class GenderNumberViewModel : ViewModel() {
    private val _genderNumber = MutableStateFlow("")
    val genderNumber : StateFlow<String> = _genderNumber

    fun setGenderNumber (newGender: String) {
        _genderNumber.value = newGender
    }
}

class TelecomViewModel : ViewModel() {
    private val _telecom = MutableStateFlow("")
    val telecom : StateFlow<String> = _telecom

    fun setTelecom (newTelecom: String) {
        _telecom.value = newTelecom
    }
}