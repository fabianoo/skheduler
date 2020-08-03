package com.skheduler.core.samples

import com.skheduler.core.dsl.seconds
import com.skheduler.core.dsl.skhedule
import com.skheduler.core.engine.SkheduleManager

fun main() {
    skhedule {
        name { "Sample" }

        every { 10.seconds() }

        task {
            HelloWorld().execute()
        }
    }

    SkheduleManager.spawn()
}
