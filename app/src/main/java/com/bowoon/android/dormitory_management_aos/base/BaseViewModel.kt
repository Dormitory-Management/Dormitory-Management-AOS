package com.bowoon.android.dormitory_management_aos.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel(), LifecycleObserver {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }
}