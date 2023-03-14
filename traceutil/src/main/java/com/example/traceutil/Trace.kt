package com.example.traceutil

import androidx.tracing.Trace

inline fun <T> traceAsync(
    sectionName: String,
    cookie: Int = System.currentTimeMillis().toInt(),
    block: () -> T
): T {
    Trace.beginAsyncSection(sectionName, cookie)
    try {
        return block()
    } finally {
        Trace.endAsyncSection(sectionName, cookie)
    }
}
