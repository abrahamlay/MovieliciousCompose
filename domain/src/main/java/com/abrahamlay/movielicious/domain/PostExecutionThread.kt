package com.abrahamlay.movielicious.domain

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler(): Scheduler
}