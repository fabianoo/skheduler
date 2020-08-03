package com.skheduler.core.dsl

import java.time.Duration

fun Number.millis(): Duration {
    return Duration.ofMillis(this.toLong())
}

fun Number.second() = seconds()
fun Number.seconds(): Duration {
    return Duration.ofSeconds(this.toLong())
}

fun Number.minute() = minutes()
fun Number.minutes(): Duration {
    return Duration.ofMinutes(this.toLong())
}

fun Number.hour() = hours()
fun Number.hours(): Duration {
    return Duration.ofHours(this.toLong())
}