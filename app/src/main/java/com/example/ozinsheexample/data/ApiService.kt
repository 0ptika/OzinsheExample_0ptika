package com.example.ozinsheexample.data

import com.example.ozinsheexample.data.model.LoginRequest
import com.example.ozinsheexample.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/V1/signin")
    suspend fun loginUser(
        @Body request: LoginRequest
    ): LoginResponse
}
