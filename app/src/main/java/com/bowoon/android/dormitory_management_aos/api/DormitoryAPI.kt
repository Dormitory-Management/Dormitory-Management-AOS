package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.*
import io.reactivex.rxjava3.disposables.CompositeDisposable

interface DormitoryAPI {
    fun doLogin(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>? = null,
        body: LoginData,
        onSuccess: ((LoginResponse) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun getToday(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>? = null,
        onSuccess: ((TodayData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun getNotice(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>? = null,
        onSuccess: ((NoticeData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun getCheck(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>? = null,
        onSuccess: ((CheckData) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )

    fun sendRoomCheck(
        compositeDisposable: CompositeDisposable,
        params: Map<String, String>? = null,
        body: CheckData,
        onSuccess:((RoomCheckResponse) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    )
}