package com.ani.online.broadcastreceivers

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

class MyService : Service() {

    private val br: BroadcastReceiver = MyReceiver()

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        registerBR()
        return START_STICKY
    }

    override fun onDestroy() {
        unregisterReceiver(br)
        super.onDestroy()
    }

    private fun registerBR() {
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(br, filter)
    }
}
