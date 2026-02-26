package com.example.ozinsheexample.data

import android.content.Context
import android.content.SharedPreferences


class SharedProvider(private val context: Context) {
    private val shared_token = "SAVE_TOKEN"

    private val preferences: SharedPreferences

        get() = context.getSharedPreferences("shared_token", Context.MODE_PRIVATE)


    fun saveToken(token: String) {
        preferences.edit().putString(shared_token, token).apply()
    }
    fun getToken(): String? {
        return preferences.getString(shared_token, "without_token").toString()
    }
    fun clearSharedPref() {
        preferences.edit().clear().apply()
    }






}