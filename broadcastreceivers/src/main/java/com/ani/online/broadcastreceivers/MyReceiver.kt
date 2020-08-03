package com.ani.online.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MyReceiver : BroadcastReceiver() {

    var myData : Any? = null
    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                Log.i("@ani", "Global Intent Found")
            }
            "com.ani.my.intent" -> {
                Log.i("@ani", "Local Intent Found")
                myData = object {

                }
            }
        }
        Log.i("@ani","Receiver ${intent.action}")
    }
}
