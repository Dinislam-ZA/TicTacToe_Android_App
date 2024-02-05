package com.example.tiktaktoe.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    val registerModel: RegisterModel = RegisterModel()
   // val userData:MutableLiveData<User> = MutableLiveData()
    val isOk:MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }


    fun tryRegistration(username:String, password: String, passwordRepeat:String, phoneNumber:String){
        viewModelScope.launch(Dispatchers.Main) {
//            userData.value = registerModel.attemptRegistration(username, password, phoneNumber).body()
 //           isOk.value = registerModel.attemptRegistration(username, password, phoneNumber).isSuccessful
            isOk.postValue(registerModel.attemptRegistration(username, password, phoneNumber).isSuccessful)
        }

    }

}