package com.ani.fragrments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(SecondFragment.getInstance("Exit"))
    }

    private fun loadFragment(fragment : Fragment) {
        val txn = supportFragmentManager.beginTransaction()
        txn.replace(R.id.fragCont, fragment)
        txn.commit()
    }
}
