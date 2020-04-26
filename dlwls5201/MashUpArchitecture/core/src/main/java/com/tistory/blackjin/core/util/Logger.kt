package com.tistory.blackjin.core.util

import android.util.Log
import com.tistory.blackjin.core.BuildConfig

object Logger {

    private const val TAG = "BlackJin"

    fun d(msg: String) {
        if (isDebug()) {
            Log.d(TAG, buildLogMsg(msg))
        }
    }
    fun i(msg: String) {
        if (isDebug()) {
            Log.i(TAG, buildLogMsg(msg))
        }
    }

    fun w(msg: String) {
        if (isDebug()) {
            Log.w(TAG, buildLogMsg(msg))
        }
    }

    fun e(msg: String) {
        if (isDebug()) {
            Log.e(TAG, buildLogMsg(msg))
        }
    }

    fun v(msg: String) {
        if (isDebug()) {
            Log.v(TAG, buildLogMsg(msg))
        }
    }

    private fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    private fun buildLogMsg(msg: String?): String {
        val sb = StringBuilder()
        if (TAG.isNotEmpty()) {
            sb.append("[").append(TAG).append("] ")
        }

        if (msg.isNullOrEmpty().not()) {
            sb.append(msg)
        }

        val stackTraceElements = Thread.currentThread().stackTrace
        if (stackTraceElements.size >= 4) {
            val element = stackTraceElements[4]
            val fullClassName = element.fileName
            val lineNumber = element.lineNumber.toString()
            sb.append(" (").append(fullClassName).append(":").append(lineNumber).append(")")
        }

        return sb.toString()
    }
}