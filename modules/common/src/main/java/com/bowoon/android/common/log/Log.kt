package com.bowoon.android.common.log

import com.bowoon.android.common.BuildConfig

object Log {
    fun i(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag(), msg)
        }
    }

    fun i(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag(), msg, throwable)
        }
    }

    fun v(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.v(tag(), msg)
        }
    }

    fun v(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag(), msg, throwable)
        }
    }

    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.d(tag(), msg)
        }
    }

    fun d(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag(), msg, throwable)
        }
    }

    fun w(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.w(tag(), msg)
        }
    }

    fun w(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag(), msg, throwable)
        }
    }

    fun e(msg: String) {
        if (BuildConfig.DEBUG) {
            android.util.Log.e(tag(), msg)
        }
    }

    fun e(msg: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag(), msg, throwable)
        }
    }

    private fun tag(): String {
        Thread.currentThread().stackTrace[4]?.let {
            val className = it.className.substring(it.className.lastIndexOf(".") + 1)
            return "$className.${it.methodName}[${it.fileName}:${it.lineNumber}]"
        }
        return "Empty Tag String"
    }
}