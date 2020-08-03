package com.ani.online.broadcastreceivers

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.location.Location
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MyService : Service() {

    private var mp : MediaPlayer? =null
    private val binder : IBinder = MyBinder()
    private var location : Location? = null

    private val br: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val btn = intent?.getStringExtra("button")
            if(btn == "play") {
                mp?.start()
                Log.i("@ani", "Playing Song")
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder = binder

    override fun onStartCommand(intent: Intent?, flagsLocalBroadcastManager: Int, startId: Int): Int {

        Log.i("@ani", "Service Started")

        val filter = IntentFilter()
        filter.addAction("com.ani.my.intent")

        LocalBroadcastManager
            .getInstance(this)
            .registerReceiver(br, filter )
        Thread {
            registerBR()
            for(i in 0..100) {
                Thread.sleep(500)
            }

            stopSelf()
        }.start()

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

    inner class MyBinder : Binder() {
        fun getService() : MyService = this@MyService
    }

    fun getMp() = mp
}
