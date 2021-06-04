package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.common.utils.rxRunOnUiThread
import com.bowoon.android.dormitory_management_aos.models.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class DormitoryAPIImpl : DormitoryAPI {
    override fun doLogin(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        body: LoginData,
        onSuccess: ((LoginResponse) -> Unit)?,
        onError: ((Throwable) -> Unit)?
    ) {
        Api.dormitory.doLogin("", body)
            .rxRunOnUiThread()
            .subscribe(
                { onSuccess?.invoke(it) },
                { e -> onError?.invoke(e) }
            ).addTo(compositeDisposable)
    }

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
        Api.dormitory.getCheck("check.json", params)
            .rxRunOnUiThread()
            .subscribe(
                { onSuccess?.invoke(it) },
                { e -> onError?.invoke(e) }
            ).addTo(compositeDisposable)
    }
}