package com.skheduler.core.domain

object SkheduleRegistry {
    private val skhedules : MutableList<Skhedule> = mutableListOf()

    fun list() = skhedules as List<Skhedule>

    infix fun register(skhedule: Skhedule) {
        skhedules.add(skhedule)
    }

}