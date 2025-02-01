package com.ralphmarondev.cowntdown.core.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.time.LocalDate

class FirstDayOfMonthWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    companion object {
        private const val CHANNEL_ID = "cowntdown_channel"
        private const val NOTIFICATION_ID = 1
    }

    override fun doWork(): Result {
        val currentDate = LocalDate.now()

        if (currentDate.dayOfMonth == 1) {
            createNotificationChannel()
            sendNotification()
        }
        return Result.success()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Cowntdown Notification",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Channel for Cowntdown app"
        }
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun sendNotification() {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle("Cowntdown")
            .setContentText("Wake up, it's the first of the month!")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }
}