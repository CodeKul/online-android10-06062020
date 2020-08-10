package com.ani.online.storage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ani.online.storage.room.DmgInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URLConnection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app = application as StorageApp
        btnWrite.setOnClickListener {
//            storeToken()
            Thread {
                app.db.dmgInfoDao().saveDmg(
                    DmgInfo(2, "xyz", 10, "${System.currentTimeMillis()}" )
                )
            }.start()
        }

        btnRead.setOnClickListener {
//            retrieveToken()

            GlobalScope.launch {
                app.db.dmgInfoDao().all().forEach {
                    Log.i("@ani" , it.mobile)
                }
            }
        }
    }

    private fun storeToken() {
        val actPref = getPreferences(Context.MODE_PRIVATE)
        val prefs = getSharedPreferences(TOKEN_PREFS, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(KEY_TOKEN, "${System.currentTimeMillis()}")
        editor.putBoolean(KEY_IS_SSL, true)
        editor.apply()
    }

    private fun retrieveToken() {
        val prefs = getSharedPreferences("token_prefs", Context.MODE_PRIVATE)
        val token = prefs.getString(KEY_TOKEN, "default")
        val isSSL = prefs.getBoolean(KEY_IS_SSL, false)
        Log.i("@ani", "Token is $token")
        Log.i("@ani", "Is SSL Enabled $isSSL")
    }

    companion object {
        const val TOKEN_PREFS = "token_prefs"
        const val KEY_TOKEN = "token"
        const val KEY_IS_SSL = "ssl_enabled"
    }
}
