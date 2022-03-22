package com.example.myapplication

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import io.github.tkrest.woah.CrashListener
import io.github.tkrest.woah.Woah

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Woah.init(object : CrashListener {
            override fun onUncaughtException(thread: Thread, throwable: Throwable) {
                showToastOnUIThread(throwable.stackTraceToString())
            }
        })
    }

    fun showToastOnUIThread(message: String?) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(
                applicationContext,
                message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}