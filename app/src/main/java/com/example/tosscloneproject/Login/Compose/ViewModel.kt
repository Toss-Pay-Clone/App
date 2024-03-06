package com.example.tosscloneproject.Login.Compose

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tosscloneproject.Login.CheckPhoneApiService
import com.example.tosscloneproject.Login.LoginApiService
import com.example.tosscloneproject.Login.NewUser
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.Login.PhoneRequest
import com.example.tosscloneproject.Login.PhoneResponse
import com.example.tosscloneproject.Login.Register.ResidentNumber
import com.example.tosscloneproject.Login.SignUpApiService
import com.example.tosscloneproject.Login.User
import com.example.tosscloneproject.Login.retrofit
import com.example.tosscloneproject.Login.signUpApiService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class PhoneNumberViewModel : ViewModel() {
    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> get() = _phoneNumber

    private val _phoneMessage = MutableStateFlow<String?>("")
    val phoneMessage: StateFlow<String?> get() = _phoneMessage

    private val _phoneResponse = MutableStateFlow<PhoneResponse?>(null)
    val phoneResponse: StateFlow<PhoneResponse?> get() = _phoneResponse

    fun setPhoneNumber(newPhone: String) {
        _phoneNumber.value = newPhone
    }

    fun checkPhoneNumber() {
        viewModelScope.launch {
            val service = retrofit.create(CheckPhoneApiService::class.java)

            withContext(Dispatchers.IO) {
                val response = service.checkPhoneNumber(PhoneRequest(_phoneNumber.value))
                try {
                    if (response.isSuccessful) {
                        Log.d("Page3","success")
                        _phoneMessage.value = response.body()?.message
                        _phoneResponse.value = response.body()
                        Log.d("Page3", _phoneMessage.value.toString())
                    } else {
                        // API 요청 실패
                        Log.d("Page3","fail")
                        val errorBody = response.errorBody()?.toString()
                        val errorResponse = Gson().fromJson(errorBody, PhoneResponse::class.java)
                        _phoneMessage.value = "httpStatus: ${errorResponse.httpStatus}, " +
                                "error: ${errorResponse.error}, " +
                                "message: ${errorResponse.message}"
                        _phoneResponse.value = errorResponse
                        Log.d("Page3", _phoneMessage.value.toString())

                    }
                } catch (e: Exception) {
                    Log.d("Page3","catch")
                    Log.d("Page3", _phoneMessage.value.toString())
                    Log.d("Page3", e.message ?: "Unknown Error")
                    _phoneMessage.value = e.message
                    _phoneResponse.value = PhoneResponse(httpStatus = "404",
                        error = "NOT_FOUND",
                        message = "해당 전화번호로 가입된 계정이 없습니다.")
                }
            }
            }

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

class SignUpViewModel (
    private val signUpApiService: SignUpApiService,
    private val userNameViewModel: UserNameViewModel,
    private val phoneNumberViewModel: PhoneNumberViewModel,
    private val birthNumberViewModel: BirthNumberViewModel,
    private val genderNumberViewModel: GenderNumberViewModel,
    private val telecomViewModel: TelecomViewModel
) : ViewModel() {

    private val _signupResult = MutableStateFlow<Boolean?>(null)
    val signupResult: StateFlow<Boolean?> get() = _signupResult

    fun signup() {
        viewModelScope.launch {

        Log.d("CheckPage", "signup() function is called")


        // gender 값을 변환
        val genderNumber = genderNumberViewModel.genderNumber.value
        val gender = when (genderNumber) {
            "1", "3" -> "MALE"
            "2", "4" -> "FEMALE"
            else -> "UNKNOWN"
        }

        // birthdate 값을 변환
        val birthNumber = birthNumberViewModel.birthNumber.value
        val yearPrefix = if (birthNumber.startsWith("0")) "20" else "19"
        val birthdate = yearPrefix + birthNumber.substring(0, 2) + "-" +
                birthNumber.substring(2, 4) + "-" +
                birthNumber.substring(4, 6) + "T00:00:00"

        val newUser = NewUser(
            name = userNameViewModel.userName.value,
            phone = phoneNumberViewModel.phoneNumber.value,
            gender = gender,
            password = "2971a",
            nationality = "KOREA",
            residentRegistrationNumberFront = birthNumberViewModel.birthNumber.value,
            residentRegistrationNumberBack = genderNumberViewModel.genderNumber.value,
            mobileCarrier = telecomViewModel.telecom.value,
            birthdate = birthdate
        )

        Log.d("SignUpViewModel", "NewUser: $newUser")


        try {
            val response = signUpApiService.signup(newUser)
            if (response.isSuccessful) {
                val responseBody = response.body()
                _signupResult.value = true
                Log.d("SignUpViewModel", "success")
                Log.d("SignUpViewModel", "Response: ${response}")

            } else {
                _signupResult.value = false
                Log.d("SignUpViewModel", "fail")
                Log.d("SignUpViewModel", "Response: ${response}")
            }

        } catch (e: Exception) {
            _signupResult.value = false
            Log.d("SignUpViewModel", "catch")
            Log.e("CheckPage", "Error during signup", e)
        }
        }
    }
}

class SignUpViewModelFactory(
    private val signUpApiService: SignUpApiService,
    private val userNameViewModel: UserNameViewModel,
    private val phoneNumberViewModel: PhoneNumberViewModel,
    private val birthNumberViewModel: BirthNumberViewModel,
    private val genderNumberViewModel: GenderNumberViewModel,
    private val telecomViewModel: TelecomViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignUpViewModel(
                signUpApiService,
                userNameViewModel,
                phoneNumberViewModel,
                birthNumberViewModel,
                genderNumberViewModel,
                telecomViewModel
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}





