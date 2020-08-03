package com.skheduler.core.domain

import com.skheduler.core.api.Schedule
import java.time.Duration
import java.time.Instant

data class FixedRate(
        val initialDelay : Duration,
        val rate : Duration
) : Schedule {
    override fun next(last: Instant?): Instant {
        return last?.plus(rate) ?: Instant.now().plus(initialDelay)
    }
}