package com.abrahamlay.movielicious.domain

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Abraham Lay on 2019-12-28.
 */

class AndroidUIThread : PostExecutionThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}