package com.example.tiktaktoe.data

data class User(
    var username:String? = null,
    var password: String? = null,
    var phonenumber: String? = null,
)

data class LoginRequest(
    var username:String? = null,
    var password: String? = null,
)

data class LoginResponse(
    var authToken:String? = null
)