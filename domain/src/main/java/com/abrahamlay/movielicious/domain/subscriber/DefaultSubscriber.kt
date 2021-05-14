package com.abrahamlay.movielicious.domain.subscriber

import io.reactivex.subscribers.DisposableSubscriber

abstract class DefaultSubscriber<T> : DisposableSubscriber<T>() {
    override fun onComplete() {
        //no implementation
    }

    override fun onNext(data: T) {
        onSuccess(ResultState.Success(data))
    }

    override fun onError(throwable: Throwable) {
        onError(ResultState.Error(throwable))
    }

    abstract fun onError(error: ResultState<T>)

    abstract fun onSuccess(data: ResultState<T>)
}