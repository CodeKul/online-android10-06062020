package com.melayer.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerViewModel : ViewModel() {

    private val _chats : MutableLiveData<List<WaData>> = MutableLiveData<List<WaData>>().apply {
        value = getData()
    }
    val chats : LiveData<List<WaData>>  get() = _chats

    private fun getData() : List<WaData> {
        val list = arrayListOf<WaData>()
        list.add(
                WaData(
                        R.drawable.ic_android_black_24dp,
                        "Android",
                        "Hey Hi",
                        "7.45 Am",
                        3,
                        true
                )
        );

        list.add(
                WaData(
                        R.drawable.ic_launcher_background,
                        "Volume",
                        "its okay",
                        "8.00 Pm",
                        45,
                        false
                )
        );

        return list
    }
}