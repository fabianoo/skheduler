package com.skheduler.core.dsl

import com.skheduler.core.api.Schedule
import com.skheduler.core.domain.FixedRate
import com.skheduler.core.domain.Skhedule
import com.skheduler.core.domain.SkheduleRegistry
import com.skheduler.core.engine.SkheduleManager
import java.time.Duration

typealias Executable = () -> Unit

@SkhedulerDslDefinition
fun schedule(block : SkhedulerBuilder.() -> Unit) = skhedule(block)

@SkhedulerDslDefinition
fun skhedule(block : SkhedulerBuilder.() -> Unit) {
    SkhedulerBuilder().apply(block).build()
}

@SkhedulerDslDefinition
class SkhedulerBuilder {
    private lateinit var name : String
    private lateinit var task : Executable
    private lateinit var schedule: Schedule

    fun name(block: () -> String) {
        name = block()
    }

    fun fixedRate(block: () -> Duration) {

    }

    fun fixedDelay(block: () -> Duration) {

    }

    fun every(block: () -> Duration) {
        schedule = FixedRate(0.millis(), block())
    }

    fun task(block : Executable) {
        task = block
    }

    fun build() {
        SkheduleRegistry register Skhedule(name, schedule, task)
    }
}