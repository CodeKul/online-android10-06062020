package com.melayer.onlineapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcData() : ViewModel() {

    private val num1Val = MutableLiveData<Int>(0)
    private val num2Val = MutableLiveData<Int>(0)
    private val resVal = MutableLiveData<Int>(0)

    val num1 : LiveData<Int> = num1Val
    val num2 : LiveData<Int> = num2Val
    val res : LiveData<Int> = resVal

     fun calc()   {
         resVal.postValue((num2Val.value ?: 0) + (num1Val.value ?: 0))
     }
}