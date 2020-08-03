package com.skheduler.core.domain

import com.skheduler.core.api.Schedule
import com.skheduler.core.dsl.Executable

data class Skhedule(
        val name : String,
        val schedule: Schedule,
        val task : Executable
)