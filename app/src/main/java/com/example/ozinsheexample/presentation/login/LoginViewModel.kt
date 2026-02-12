package com.example.ozinsheexample.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ozinsheexample.data.ApiService
import com.example.ozinsheexample.data.ServiceBuilder
import com.example.ozinsheexample.data.model.LoginRequest
import com.example.ozinsheexample.data.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val _loginResponse: MutableLiveData<LoginResponse> = MutableLiveData()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    private var _errorResponse: MutableLiveData<String> = MutableLiveData()
    var errorResponse: LiveData<String> = _errorResponse

    fun loginUser(email: String , password: String) {
        viewModelScope.launch(Dispatchers.IO){
            val response = ServiceBuilder.buildService(ApiService::class.java)

                runCatching { response.loginUser(LoginRequest(email, password)) }
                .onSuccess {  _loginResponse.postValue(it) }
                .onFailure { _errorResponse.postValue(it.message) }



            }

        }
    }
