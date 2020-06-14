package com.melayer.onlineapp

import androidx.lifecycle.ViewModel

class CalcData() : ViewModel() {
    var num1 = 0
    var num2 = 0
    var res = 0

     fun calc()  : Int {
         res = num1 + num2
         return res
     }
}