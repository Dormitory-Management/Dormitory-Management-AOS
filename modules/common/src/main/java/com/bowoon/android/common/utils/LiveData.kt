package com.bowoon.android.common.utils

import androidx.lifecycle.MutableLiveData

@JvmName("shotOneInt")
fun MutableLiveData<Int>.shotOne() {
    this.value = 1
    this.postValue(-1)
}

@JvmName("shotOneBoolean")
fun MutableLiveData<Boolean>.shotOne() {
    this.value = true
    this.postValue(false)
}

fun MutableLiveData<Int>.shotOne(value: Int) {
    this.value = value
    this.postValue(-1)
}

fun MutableLiveData<Boolean>.shotOne(value: Boolean) {
    this.value = value
    this.postValue(!value)
}