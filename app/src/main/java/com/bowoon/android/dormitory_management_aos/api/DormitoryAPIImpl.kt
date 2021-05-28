package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.common.utils.rxRunOnUiThread
import com.bowoon.android.dormitory_management_aos.models.TodayData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class DormitoryAPIImpl : DormitoryAPI {
    override fun getToday(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((TodayData) -> Unit)?,
        onError: ((Throwable) -> Unit)?
    ) {
        Api.dormitory.getToday("today.json")
            .rxRunOnUiThread()
            .subscribe(
                { onSuccess?.invoke(it) },
                { e -> onError?.invoke(e) }
            ).addTo(compositeDisposable)
    }
}