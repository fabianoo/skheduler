package com.skheduler.core.api

import java.time.Instant

interface Schedule {
    fun next(last : Instant? = null) : Instant
}