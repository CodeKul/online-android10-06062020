package com.melayer.onlineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.melayer.onlineapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(CalcData::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
           viewmodel = viewModel
           lifecycleOwner = this@MainActivity
       }

        viewModel.num1.observe(this, Observer {
            Log.i("@ani", "Changed Num1 $it")
            val num1 = if(it.isNotEmpty()) Integer.parseInt(it ?: "0") else 0
            val num2 = Integer.parseInt(viewModel.num2.value ?: "0")
            viewModel.setResult(num1 + num2)
        })

        viewModel.num2.observe(this, Observer {
            Log.i("@ani", "Changed Num1 $it")
            val num1 = Integer.parseInt(viewModel.num1.value ?: "0")
            val num2 = if(it.isNotEmpty()) Integer.parseInt(it ?: "0") else 0
            viewModel.setResult(num1+num2)
        })
    }
}