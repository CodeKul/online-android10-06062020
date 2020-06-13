package com.melayer.onlineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener{
            Log.i("@ani", "Button Clicked")

            val num1 = Integer.parseInt(etNumOne.text.toString())
            val num2 = Integer.parseInt(etNumTwo.text.toString())
            txtDt.text = "${num1 + num2}"
        }
    }
}