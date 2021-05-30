package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.*
import io.reactivex.rxjava3.disposables.CompositeDisposable

interface DormitoryAPI {
    fun doLogin(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        body: LoginData,
        onSuccess: ((LoginResponse) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun getToday(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((TodayData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun getNotice(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((NoticeData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun getCheck(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>,
        onSuccess: ((CheckData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )
}