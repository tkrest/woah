package io.github.tkrest.woah

import androidx.annotation.Keep

@Keep
interface CrashListener {
    fun onUncaughtException(thread: Thread, throwable: Throwable)
}

@Keep
object Woah {
    @JvmStatic
    fun init(crashListener: CrashListener) {
        Thread.setDefaultUncaughtExceptionHandler { p0, p1 ->
             crashListener.onUncaughtException(p0, p1)
        }
    }
}