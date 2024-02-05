package com.example.tiktaktoe.ui.login

import com.example.tiktaktoe.data.RetrofitClient
import com.example.tiktaktoe.data.LoginRequest
import okhttp3.ResponseBody
import retrofit2.Response

class LoginModel {

    private val authService = RetrofitClient.authService

    suspend fun loginUser(userDetails:LoginRequest):Response<ResponseBody>{
        return authService.loginUser(userDetails)
    }
}