package com.skheduler.core.api

import com.skheduler.core.domain.TaskSchedule

object TaskScheduleRepository {
    private val map = mutableMapOf<String, TaskSchedule>()

    fun find(name : String) : TaskSchedule? {
        return map[name]
    }

    fun save(taskSchedule: TaskSchedule) {
        map[taskSchedule.id] = taskSchedule
    }
}