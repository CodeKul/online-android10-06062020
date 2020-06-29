package com.ani.interact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    * 1. Starting Activity
    * 2. Passing data to activity
    * 3. Processing the data
    * 4. Sending back results
    * */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cls : Class<SimpleActivity> = SimpleActivity::class.java
        btNxt.setOnClickListener {
            val intent: Intent = Intent(this, cls)
            val bnd = Bundle()
            bnd.putString("mobile", etMb.text?.toString() ?: "default")
            intent.putExtras(bnd)
            startActivity(intent)
        }
    }
}
