package com.ani.online.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("@ani","Receiver ${intent.action}")


//        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
    }
}
