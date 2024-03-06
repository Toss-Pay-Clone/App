package com.example.tosscloneproject.Login

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private
    const val BASE_URL = "http://pay-toss.kro.kr:8080"
    val loginapi: LoginApiService by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(LoginApiService::class.java)
    }
}