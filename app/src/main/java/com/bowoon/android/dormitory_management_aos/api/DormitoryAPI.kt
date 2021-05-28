package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.TodayData
import io.reactivex.rxjava3.disposables.CompositeDisposable

interface DormitoryAPI {
    fun getToday(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((TodayData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )
}