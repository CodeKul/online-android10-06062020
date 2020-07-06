package com.ani.interact

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationManagerCompat
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

        swtAld.setOnCheckedChangeListener { _ , isChecked ->
            if(isChecked) {
                appNotificationAct()
            }
        }

        btNxt.setOnClickListener { complexActivity() }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            REQUEST_SIMPLE_ACTIVITY -> {
                if(resultCode == Activity.RESULT_OK){
                    val bkBnd = data?.extras
                    val nm = bkBnd?.getString("mobName")
                    etMb.setText(nm.toString())
                }
            }
            REQUEST_DISABLE_NOTIFICATION -> {
                Log.i("@ani" ," Result is ${resultCode == Activity.RESULT_OK} - $resultCode" )
                swtAld.isChecked = NotificationManagerCompat.from(this).areNotificationsEnabled().not()
            }
        }
    }

    private fun normalIntent() {
        val cls : Class<SimpleActivity> = SimpleActivity::class.java
        val intent: Intent = Intent(this, cls)
        val bnd = Bundle()
        bnd.putString("mobile", etMb.text?.toString() ?: "default")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtras(bnd)
        startActivityForResult(intent, REQUEST_SIMPLE_ACTIVITY)
    }

    private fun appNotificationAct() {
        val intent = Intent()
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("app_package", packageName)
                intent.putExtra("app_uid", applicationInfo.uid)
            }
            else -> {
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                intent.data = Uri.parse("package:$packageName")
            }
        }
        startActivityForResult(intent, REQUEST_DISABLE_NOTIFICATION)
    }

    private fun dial() {
        val dialIntent = Intent()
        dialIntent.action = Intent.ACTION_DIAL
        startActivity(dialIntent)
    }

    private fun implicitIntent() {
        val impIntent = Intent()
        impIntent.action = "com.ani.action.simple.news"
        startActivity(impIntent)
    }

    private fun complexActivity() {
        val cmpInt = Intent()
        cmpInt.action = "com.ani.action"
//        cmpInt.data = Uri.parse("http://ani.com")
        startActivity(cmpInt)
    }

    companion object {
        const val REQUEST_DISABLE_NOTIFICATION = 5698
        const val REQUEST_SIMPLE_ACTIVITY = 1234
    }
}
