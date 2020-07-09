package com.ani.fragrments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.fragment_second.*

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

        btOk.text = arguments?.getString(KEY_BTN) ?: "Android"

        val btn = view.findViewById<Button>(R.id.btOk)
        btn.text = arguments?.getString(KEY_BTN) ?: "Android"

        skBrRd.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                (activity as MainActivity)
                    .generateColor(progress, skBrGr.progress, skBrBl.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {


            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        skBrGr.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                (activity as MainActivity)
                    .generateColor(skBrRd.progress, progress, skBrBl.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        skBrBl.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                (activity as MainActivity).generateColor(skBrRd.progress, skBrGr.progress, progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
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