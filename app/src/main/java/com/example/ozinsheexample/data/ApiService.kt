package com.example.ozinsheexample.data

import com.example.ozinsheexample.data.model.LoginRequest
import com.example.ozinsheexample.data.model.LoginResponse
import com.example.ozinsheexample.data.model.MainMoviesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @GET("/core/V1/movies_main")
    suspend fun getMainMovies(@Header ("Authorization") token: String ): MainMoviesResponse


    @POST("/auth/V1/signin")
    suspend fun loginUser(
        @Body request: LoginRequest
    ): LoginResponse
}
