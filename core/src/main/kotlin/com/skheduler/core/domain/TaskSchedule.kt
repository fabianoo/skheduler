package com.skheduler.core.domain

import java.time.Instant

data class TaskSchedule(
        val id: String,
        val lock: Boolean,
        val lastRun: Instant?,
        val nextRun: Instant
) {
    fun isTimeToRun() : Boolean {
        return nextRun <= Instant.now()
    }
}