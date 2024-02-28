package com.example.tosscloneproject.Consumption

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TransactionApiService {
    @GET("/api/v1/bank/accounts/transactions/date")
    suspend fun getTransactionHistory(
        @Query("year") year:Int,
        @Query("month") month: Int,
        @Header("Cookie") cookie: String
    ): ResponseBody
}

val retrofit = Retrofit.Builder()
    .baseUrl("http://pay-toss.kro.kr:8080")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val transactionApiService = retrofit.create(TransactionApiService::class.java)
