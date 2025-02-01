package com.ralphmarondev.cowntdown

import android.app.Application
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.ralphmarondev.cowntdown.core.worker.FirstDayOfMonthWorker
import java.util.concurrent.TimeUnit

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

//        WorkManager.initialize(this, WorkManager.getInstance(this).configuration)
        // WorkerManager is automatically initialized by the system. getsung? ^^

        val workRequest = PeriodicWorkRequestBuilder<FirstDayOfMonthWorker>(1, TimeUnit.DAYS)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }
}