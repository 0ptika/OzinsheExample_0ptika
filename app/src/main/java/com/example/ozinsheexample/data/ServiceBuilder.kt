package com.example.ozinsheexample.data

import android.app.Service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.contracts.Returns

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val  retrofit = Retrofit.Builder()
        .baseUrl("http://api.ozinshe.com") //
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}