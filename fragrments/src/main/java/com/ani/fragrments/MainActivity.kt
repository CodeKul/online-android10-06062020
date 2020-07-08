package com.ani.fragrments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txn = supportFragmentManager.beginTransaction()
        txn.replace(R.id.fragCont, SecondFragment())
        txn.commit()
    }
}
