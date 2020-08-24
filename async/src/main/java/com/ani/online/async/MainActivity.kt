package com.ani.online.async

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.internal.operators.observable.ObservableInterval
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Handler
        // runonuithread
        // rxjava

        val handler = Handler(Looper.getMainLooper())
        btn.setOnClickListener {
            /* //runonuithread
            Thread {
                for(i in 0..10) {
                    Thread.sleep(1000)
                    runOnUiThread { txtCnt.text = "$i"  }
                }
            }.start()
            */

            /* //Handler
            Thread {
                for(i in 0..10) {
                    Thread.sleep(1000)
                    handler.post {
                        txtCnt.text ="$i"
                    }
                }
            }.start()*/

            ObservableInterval.interval( 1000, TimeUnit.MILLISECONDS )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext { txtCnt.text = "$it" }
                .doOnError { Log.i("@ani", "ERROR $it") }
                .doOnComplete { Log.i("@ani", "C $it") }
                .subscribe()
        }
    }
}
