package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface Dormitory {
    @POST
    fun doLogin(@Url url: String, @Body loginData: LoginData): Single<LoginResponse>

    @GET
    fun getToday(@Url url: String): Single<TodayData>

    @GET
    fun getNotice(@Url url: String): Single<NoticeData>

    @GET
    fun getCheck(@Url url: String): Single<CheckData>
}