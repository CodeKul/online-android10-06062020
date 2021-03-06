package com.melayer.onlineapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.melayer.onlineapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val viewModel by lazy {

        ViewModelProvider(this)
            .get(LoginViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login).apply {
            lifecycleOwner = this@LoginActivity
            vm = viewModel
        }

        viewModel.usNm.observe(this, Observer {
            if(it.length > 10) etUsNm.error = "Length Should not exceed 10"
            else etUsNm.error = null
        })

        viewModel.areCredsOk.observe(this, Observer {
            Toast.makeText(this@LoginActivity, "Login is $it", Toast.LENGTH_SHORT).show()
            if(it) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }
        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}