package com.skheduler.core.engine

import com.skheduler.core.api.TaskScheduleRepository
import com.skheduler.core.domain.Skhedule
import com.skheduler.core.domain.SkheduleRegistry
import com.skheduler.core.domain.TaskSchedule
import java.time.Instant
import java.util.*
import java.util.concurrent.Executors
import kotlin.concurrent.scheduleAtFixedRate

object SkheduleManager {

    private val executor = Executors.newFixedThreadPool(4)

    fun spawn() {
        Timer().scheduleAtFixedRate(0, 1_000) {
            println("Spawning...${Instant.now()}")

            SkheduleRegistry.list().forEach {
                executor.execute {
                    val task = task(it)
                    if(task.isTimeToRun()) {
                        it.task()
                        val now = Instant.now()
                        val newTask = TaskSchedule(task.id, false, now, it.schedule.next(now))
                        TaskScheduleRepository.save(newTask)
                    }
                }
            }
        }
    }

    private fun task(skhedule: Skhedule) : TaskSchedule {
        val task = TaskScheduleRepository.find(skhedule.name)

        return if(task != null) {
            task
        } else {
            val newTask = TaskSchedule(skhedule.name, false, null, skhedule.schedule.next())
            TaskScheduleRepository.save(newTask)
            newTask
        }
    }
}