package com.example.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.example.notificationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val channelID = "com.example.notificationdemo.channel1"
    private var notificationManager: NotificationManager? = null
    private val KEY_REPLY = "key_reply"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "DemoChannel", "This is a demo")

        binding.button.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {
        val notificationId = 45
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(this, DetailsActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Insert your name here")
            build()
        }
        val replyAction = NotificationCompat.Action.Builder(
            0,
            "REPLY",
            pendingIntent
        ).addRemoteInput(remoteInput)
            .build()

        val pendingIntent2 = PendingIntent.getActivity(
            this,
            0,
            Intent(this, DetailsActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val action2 = NotificationCompat.Action.Builder(R.drawable.ic_android_24dp, "Details", pendingIntent2).build()

        val pendingIntent3 = PendingIntent.getActivity(
            this,
            0,
            Intent(this, SettingsActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val action3 = NotificationCompat.Action.Builder(R.drawable.ic_android_24dp, "Settings", pendingIntent3).build()

        val notification = NotificationCompat.Builder(this@MainActivity, channelID)
            .setSmallIcon(R.drawable.ic_android_24dp)
            .setContentTitle("Demo Title")
            .setContentText("Demo Notification")
            .setAutoCancel(true)
            .addAction(action2)
            .addAction(action3)
            .addAction(replyAction)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager?.notify(notificationId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }
}