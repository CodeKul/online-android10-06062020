package com.ani.online.storage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWrite.setOnClickListener {
            storeToken()
        }

        btnRead.setOnClickListener {
            retrieveToken()
        }
    }

    private fun storeToken() {
        val actPref = getPreferences(Context.MODE_PRIVATE)
        val prefs = getSharedPreferences("token_prefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(KEY_TOKEN, "${System.currentTimeMillis()}")
        editor.apply()
    }

    private fun retrieveToken() {
        val prefs = getSharedPreferences("token_prefs", Context.MODE_PRIVATE)
        val token = prefs.getString(KEY_TOKEN, "default")
        Log.i("@ani", "Token is $token")
    }

    companion object {
        const val KEY_TOKEN = "token"
    }
}
