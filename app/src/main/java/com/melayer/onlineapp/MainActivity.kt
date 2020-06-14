package com.melayer.onlineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(CalcData::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //suvarna22kar30@gmail.com
        //mahavirdere@gmail.com

        setContentView(R.layout.activity_main)
    }

    private fun syntheticApproach() {
//        val dt = com.melayer.onlineapp.CalcData(12, 45, 0)
//        etNumOne.setText("${dt.num1}")
//        etNumTwo.setText("${dt.num2}")


        btnOk.setOnClickListener {
            Log.i("@ani", "Button Clicked")

           viewModel.num1 = Integer.parseInt(etNumOne.text.toString())
            viewModel.num2 = Integer.parseInt(etNumTwo.text.toString())
            txtDt.text = "${viewModel.calc()}"
        }
    }

    private fun usualApproach() {
//        val dt = com.melayer.onlineapp.CalcData(12, 45, 0)
//        etNumOne.setText("${dt.num1}")
//        etNumTwo.setText("${dt.num2}")
//
//        val et1 = findViewById<EditText>(R.id.etNumOne)
//        val et2 = findViewById<EditText>(R.id.etNumTwo)
//
//        et1.setText("${dt.num1}")
//        et2.setText("${dt.num2}")
//
//        val btn : Button = findViewById<Button>(R.id.btnOk)
//        btn.setOnClickListener { vw -> }
    }
}