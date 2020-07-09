package com.ani.fragrments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.btOk)
        btn.text = arguments?.getString(KEY_BTN) ?: "Android"
    }

    companion object {

        const val KEY_BTN = "key_btn"

        fun getInstance(txt : String) : SecondFragment {
            val frag = SecondFragment()
            val bnd = Bundle()
            bnd.putString(KEY_BTN, txt)
            frag.arguments = bnd
            return frag
        }
    }
}