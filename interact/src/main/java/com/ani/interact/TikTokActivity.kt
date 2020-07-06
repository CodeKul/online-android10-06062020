package com.ani.interact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_tik_tok.*

class TikTokActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tik_tok)

        /**
         *  - Android (Kotlin), iOS (Swift) Native Apps
         *  - Backend, Go Gin, GORM
         *  - Database - PostgresSql, RethinkDb
         *  - Angular 9 - Admin panel
         *  - Payment - UPI or Bitcoin Api
         *
         * */

        button?.setOnClickListener {

        }

        //aapt - android asset packaging tool
        R.drawable.tiktok
        R.color.colorAccent
        val header = resources.getString(R.string.tiktok_header)
        val colAsc = resources.getColor(R.color.colorAccent)
        val cmpCol = ContextCompat.getColor(this, R.color.colorAccent)

        textView.setOnClickListener {  }
    }
}