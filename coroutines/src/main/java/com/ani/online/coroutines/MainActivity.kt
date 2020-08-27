package com.ani.online.coroutines

import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCnt.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                startCounter()
            }
        }
    }

    private suspend fun startCounter() {
        for (i in 10 downTo 0) {
            delay(1000)
            Log.i("@ani", "$i")
            updateUI(i)
        }
        launchRocket()
    }

    private suspend fun updateUI(num : Int) {
        CoroutineScope(Dispatchers.Main).launch { txtCnt.text = "$num"  }
    }

    private fun launchRocket() {
        val animation: Animation  = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.rocket_translate
        )
        imgRkt.animation = animation
    }
}
