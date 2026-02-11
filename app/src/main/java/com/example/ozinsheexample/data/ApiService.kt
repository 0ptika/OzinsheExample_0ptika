package com.example.ozinsheexample.data

import com.example.ozinsheexample.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/V1/signin")
    suspend fun  loginUser(email: String, @Body loginRequest: String): LoginResponse
}