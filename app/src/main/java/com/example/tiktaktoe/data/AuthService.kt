package com.example.tiktaktoe.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface AuthService {

    @POST("users/registrations")
    suspend fun registerUser(@Body userDetail:User): Response<User>

    @POST("login")
    @Headers("Content-Type: application/json")
    suspend fun loginUser(@Body userDetail:LoginRequest): Response<ResponseBody>

}