package com.example.ozinsheexample.data.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: Int, // 25986
    @SerializedName("username")
    val username: String, // string45129@gmail.com
    @SerializedName("email")
    val email: String, // string45129@gmail.com
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("tokenType")
    val tokenType: String, // Bearer
    @SerializedName("accessToken")
    val accessToken: String // eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmc0NTEyOUBnbWFpbC5jb20iLCJpYXQiOjE3NzA3MzkwODAsImV4cCI6MTgwMjI3NTA4MH0.nK1NzeYVxKITPJbqfh59t1U-KyHSKMRV8uiKY4kejkyJr56jz6OPJmhyvnSgBg1iCHkm4mfoLk8_uQ-ZFI3r0Q
)


