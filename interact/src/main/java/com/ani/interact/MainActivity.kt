package com.ani.interact

import android.app.Activity
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
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtras(bnd)
            startActivityForResult(intent, 1234)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            1234 -> {
                if(resultCode == Activity.RESULT_OK){
                    val bkBnd = data?.extras
                    val nm = bkBnd?.getString("mobName")
                    etMb.setText(nm.toString())
                }
            }
        }
    }
}
