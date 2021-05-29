package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.common.utils.rxRunOnUiThread
import com.bowoon.android.dormitory_management_aos.models.CheckData
import com.bowoon.android.dormitory_management_aos.models.NoticeData
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

    override fun getNotice(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((NoticeData) -> Unit)?,
        onError: ((Throwable) -> Unit)?
    ) {
        Api.dormitory.getNotice("notice.json")
            .rxRunOnUiThread()
            .subscribe(
                { onSuccess?.invoke(it) },
                { e -> onError?.invoke(e) }
            ).addTo(compositeDisposable)
    }

    override fun getCheck(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((CheckData) -> Unit)?,
        onError: ((Throwable) -> Unit)?
    ) {
        Api.dormitory.getCheck("check.json")
            .rxRunOnUiThread()
            .subscribe(
                { onSuccess?.invoke(it) },
                { e -> onError?.invoke(e) }
            ).addTo(compositeDisposable)
    }
}