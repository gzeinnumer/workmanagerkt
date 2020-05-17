package com.gzeinnumer.workmanagerkt

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class NotificationReceiver : BroadcastReceiver() {
    //akan di aktifkan ketika notifiasi di kirim, janga lupa daftarkan di manifest
    override fun onReceive(context: Context, intent: Intent) {
        val mWorkManager = WorkManager.getInstance()
        val workRequest = PeriodicWorkRequest.Builder(NotificationWorker::class.java, 15, TimeUnit.MINUTES).build()
        mWorkManager.enqueue(workRequest)
    }
}