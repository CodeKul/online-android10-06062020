package com.ani.interact

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {

    private val names = arrayListOf<Info>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        names.add(Info("abc", "1234"))
        names.add(Info("pqr", "4567"))

        val bnd = intent?.extras
        val mob = bnd?.getString("mobile") ?: "default"

        txtMb.text = mob

        btBk.setOnClickListener {
            val bkInt = Intent()
            val bndBk = Bundle()
            bndBk.putString("mobName", findInfo(mob)?.name ?: "default")
            bkInt.putExtras(bndBk)
            setResult(Activity.RESULT_OK, bkInt)
            finish()
        }
    }

    private fun findInfo(mob : String) : Info?  = names.find { info -> info.num == mob }

    data class Info(
        val name : String,
        val num : String
    )
}