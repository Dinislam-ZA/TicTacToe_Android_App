package com.example.tiktaktoe.ui.registration

import com.example.tiktaktoe.data.RetrofitClient
import com.example.tiktaktoe.data.User
import retrofit2.Response

class RegisterModel {


    suspend fun attemptRegistration(username:String, password: String, phoneNumber:String): Response<User> {
        val userDetails = User(username, password, phoneNumber)
        return RetrofitClient.authService.registerUser(userDetails)
    }

    /*suspend fun returnPost(): Response<Post> {
        return RetrofitClient.authService.getPosts()
    }*/
}