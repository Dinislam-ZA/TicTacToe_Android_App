package com.example.tiktaktoe.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiktaktoe.data.LoginRequest
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {
    private val model: LoginModel = LoginModel()


    val isOk:MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }

    fun loginUser(userDetails: LoginRequest){
        viewModelScope.launch {
            val res = model.loginUser(userDetails)
            if(res.code() != 403){
                val token = res.headers() ["Authorization"] as String
                isOk.postValue(true)
            }
            else{
                Log.d("opa", "herovo")
            }
        }
    }

}