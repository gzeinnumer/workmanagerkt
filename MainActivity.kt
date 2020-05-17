package com.gzeinnumer.workmanagerkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lansung request worker untuk bekerja
        val mWorkManager = WorkManager.getInstance(applicationContext)
        val workRequest = PeriodicWorkRequest.Builder(NotificationWorker::class.java, 15, TimeUnit.MINUTES).build()
        mWorkManager.enqueue(workRequest)
    }
}
