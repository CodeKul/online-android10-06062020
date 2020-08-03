package com.melayer.onlineapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

//    private val _usNm : MutableLiveData<String> = MutableLiveData("Android")
//    private val _pass : MutableLiveData<String> = MutableLiveData("Android")

    val usNm  = MutableLiveData<String>()
    val pass = MutableLiveData<String>()
    val areCredsOk = MutableLiveData<Boolean>()

    fun login() {
        areCredsOk.value = (usNm.value == "android" && pass.value =="android")
        Log.i("@ani", "User - ${usNm.value} Pass - ${pass.value}")
    }
}