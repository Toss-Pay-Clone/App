package com.example.tosscloneproject.Login

import com.google.gson.annotations.SerializedName

// Check PhoneNumber
data class PhoneRequest(
    val phone: String
)
data class PhoneResponse(
    val httpStatus: String,
    val error: String,
    val message: String,
//    val data: String
)

// Login
data class LoginRequest(
    val password: String
)

data class LoginResponse(
    val httpStatus: String,
    val message: String,
    val data: String
)

// Register
data class NewUser(
    val name: String,
    val phone: String,
    val gender: String,
    val password: String,
    val nationality: String,
    val residentRegistrationNumberFront: String,
    val residentRegistrationNumberBack: String,
    val mobileCarrier: String,
    val birthdate: String
) {
    override fun toString(): String {
        return "NewUser(name='$name', phone='$phone', gender='$gender', password='$password', nationality='$nationality', residentRegistrationNumberFront='$residentRegistrationNumberFront', residentRegistrationNumberBack='$residentRegistrationNumberBack', mobileCarrier='$mobileCarrier', birthdate='$birthdate')"
    }
}

data class User(
    val id: Int,
    val name: String,
    val createdAt: String
)