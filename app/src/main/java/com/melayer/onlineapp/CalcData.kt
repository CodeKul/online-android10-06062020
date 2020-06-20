package com.melayer.onlineapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcData : ViewModel() {

    private val _res : MutableLiveData<String> = MutableLiveData()

    val res : LiveData<String> get() = _res
    val num1 = MutableLiveData<String>()
    val num2 = MutableLiveData<String>()

    fun calc()   {
         Log.i("@ani", "res is ${res.value}")
        _res.value = ""+ (Integer.parseInt(num1.value ?: "0") + Integer.parseInt(num2.value ?: "0"))
     }

    fun setResult(res : Int) {
        _res.value = ""+res
    }
}