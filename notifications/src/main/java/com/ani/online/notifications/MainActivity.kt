package com.ani.online.notifications

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            Toast.makeText(this, "Its 10", Toast.LENGTH_SHORT).show()
            hello()
        } else {
            Toast.makeText(this, "Its Lower", Toast.LENGTH_LONG).show()
        }

        btnClk.setOnClickListener {
            customDialog()
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun hello() {

    }

    private fun statusBarNotification() {
        val intent = Intent(this, InfoActivity::class.java )
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val pi = PendingIntent.getActivity(
                this,
                1234,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            val channelId = "ani"
            val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Title")
                .setContentText("Content")
                .setOngoing(true)
                .setContentIntent(pi)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(
                    R.drawable.ic_baseline_play_circle_filled_24,
                    "Play",
                    pi
                )
                .addAction(
                    R.drawable.ic_baseline_pause_circle_filled_24,
                    "Pause",
                    pi
                )

            val name = "Ani"
            val descriptionText = "description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(123, builder.build() )
        }
        else {
            val builder = NotificationCompat.Builder(this, "")
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Title")
                .setContentText("Content")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(123, builder.build())
        }
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.ic_baseline_notifications_24)
            .setTitle("Title")
            .setMessage("Message")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Yes Clicked", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "No Clicked", Toast.LENGTH_SHORT).show()
            }
        val ad = builder.create()
        ad.show()
    }

    private fun datePicker() {
        val dpd = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                Toast.makeText(this, "$dayOfMonth - ${month+1} - $year", Toast.LENGTH_SHORT).show()
            },
            2020,
            8,
            1
        )
        dpd.show()
    }

    private fun timePicker() {
        // Homework
    }

    private fun customDialog() {
        val appDialog = AppDialogFragment() //Homework -> getting event here
        appDialog.show(supportFragmentManager, AppDialogFragment.DIALOG_DELETE_CONFIRM)
    }
}
